package com.hellogame;

import java.util.Random;

import android.util.Log;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.box2dforandroid.Body;
import com.box2dforandroid.BodyDef;
import com.box2dforandroid.BodyDef.BodyType;
import com.box2dforandroid.Box2DDebugRenderer;
import com.box2dforandroid.CircleShape;
import com.box2dforandroid.Contact;
import com.box2dforandroid.ContactImpulse;
import com.box2dforandroid.ContactListener;
import com.box2dforandroid.Fixture;
import com.box2dforandroid.FixtureDef;
import com.box2dforandroid.Manifold;
import com.box2dforandroid.PolygonShape;
import com.box2dforandroid.QueryCallback;
import com.box2dforandroid.World;
import com.box2dforandroid.WorldManifold;
import com.box2dforandroid.joints.MouseJoint;
import com.box2dforandroid.joints.MouseJointDef;

public class Box2DTestGame implements ApplicationListener, ContactListener,
		InputProcessor {

	protected static final String tag = "Box2DTestGame";
	protected OrthographicCamera camera;
	protected Box2DDebugRenderer renderer; // �����û�����
	protected World world;
	final int k_maxContactPoints = 2048;
	protected Body groundBody;
	protected ContactPoint m_points[] = new ContactPoint[k_maxContactPoints];
	protected int m_pointCount;
	protected Body bombBody = null;
	protected MouseJoint mouseJoint;
	protected Vector2 bombSpawnPoint;
	protected boolean bombSpawning;
	protected Vector2 mouseWorld;
	protected int stepCount;

	class Settings {
		public Settings() {
			viewCenter.set(0.0f, 20.0f);
			hz = 60.0f;
			velocityIterations = 8;
			positionIterations = 3;
			drawShapes = 1;
			drawJoints = 1;
			drawAABBs = 0;
			drawContactPoints = 0;
			drawContactNormals = 0;
			drawContactImpulse = 0;
			drawFrictionImpulse = 0;
			drawCOMs = 0;
			drawStats = 0;
			drawProfile = 0;
			enableWarmStarting = 1;
			enableContinuous = 1;
			enableSubStepping = 0;
			enableSleep = 1;
			pause = 0;
			singleStep = 0;
		}

		Vector2 viewCenter;
		float hz;
		int velocityIterations;
		int positionIterations;
		int drawShapes;
		int drawJoints;
		int drawAABBs;
		int drawContactPoints;
		int drawContactNormals;
		int drawContactImpulse;
		int drawFrictionImpulse;
		int drawCOMs;
		int drawStats;
		int drawProfile;
		int enableWarmStarting;
		int enableContinuous;
		int enableSubStepping;
		int enableSleep;
		int pause;
		int singleStep;
	};

	enum PointState {
		nullState, // /< point does not exist
		addState, // /< point was added in the update
		persistState, // /< point persisted across the update
		removeState // /< point was removed in the update
	}

	class ContactPoint {
		Fixture fixtureA;
		Fixture fixtureB;
		Vector2 normal;
		Vector2 position;
		PointState state;
		float normalImpulse;
		float tangentImpulse;
	};

	class MYQueryCallback implements QueryCallback {
		Vector2 point = null;

		public MYQueryCallback(Vector2 p) {
			super();
			this.point = p;
		}

		public Fixture fixture = null;

		@Override
		public boolean reportFixture(Fixture f) {
			Body body = f.getBody();
			if (body.getType() == BodyType.DynamicBody) {
				boolean inside = f.testPoint(point);
				if (inside) {
					this.fixture = f;
					// We are done, terminate the query.
					return false;
				}
			}

			// Continue the query.
			return true;
		}
	}

	protected float RandomFloat() {
		Random random = new Random();
		float f = random.nextFloat()*10;
		boolean b = random.nextBoolean();
		if (b)
			return f;
		return -f;
	}

	public Vector2 ConvertScreenToWorld(int x, int y) {
		Vector2 p = new Vector2();
		p.x = x / 10;
		p.y = y / 20;
		return p;
	}

	public void MouseDown(Vector2 p) {
		mouseWorld = p;
		if (mouseJoint != null) {
			return;
		}
		// Make a small box.
		/*
		 * b2AABB aabb; b2Vec2 d; d.Set(0.001f, 0.001f); aabb.lowerBound = p -
		 * d; aabb.upperBound = p + d;
		 */
		float lowerX = p.x - 0.001f;
		float lowerY = p.y - 0.001f;
		float upperX = p.x + 0.001f;
		float upperY = p.y + 0.001f;
		// Query the world for overlapping shapes.
		MYQueryCallback callback = new MYQueryCallback(p);
		this.world.QueryAABB(callback, lowerX, lowerY, upperX, upperY);
		if (callback.fixture != null) {
			Body body = callback.fixture.getBody();
			MouseJointDef md = new MouseJointDef();
			md.bodyA = groundBody;
			md.bodyB = body;
			md.target.x = p.x;
			md.target.y = p.y;
			md.maxForce = 1000.0f * body.getMass();
			mouseJoint = (MouseJoint) world.createJoint(md);
			body.setAwake(true);
		}
	}

	public void ShiftMouseDown(Vector2 p) {
		mouseWorld = p;
		if (mouseJoint != null) {
			return;
		}
		SpawnBomb(p);
	}

	public void MouseUp(Vector2 p) {
		if (mouseJoint != null) {
			world.destroyJoint(mouseJoint);
			mouseJoint = null;
		}

		if (bombSpawning) {
			CompleteBombSpawn(p);
		}
	}

	public void CompleteBombSpawn(Vector2 p) {
		if (bombSpawning == false) {
			return;
		}
		final float multiplier = 30.0f;
		Vector2 vel = new Vector2();
		vel.x -= p.x;
		vel.y -= p.y;
		vel.x *= multiplier;
		vel.y *= multiplier;
		LaunchBomb(bombSpawnPoint, vel);
		bombSpawning = false;

	}

	public void LaunchBomb() {
		Vector2 position = new Vector2(RandomFloat(), 30.0f);
		Vector2 velocity = new Vector2(position);
		velocity.x *= -5;
		velocity.y *= -5;
		LaunchBomb(position, velocity);

	}

	public void LaunchBomb(Vector2 position, Vector2 velocity) {
		if (bombBody != null) {
			world.destroyBody(bombBody);
			bombBody = null;
		}

		BodyDef bd = new BodyDef();
		bd.type = BodyDef.BodyType.DynamicBody;
		bd.position.x = position.x;
		bd.position.y = position.y;
		bd.bullet = true;
		bombBody = world.createBody(bd);
		bombBody.setLinearVelocity(velocity);

		CircleShape circle = new CircleShape();
		circle.setRadius(0.3f);

		FixtureDef fd = new FixtureDef();
		fd.shape = circle;
		fd.density = 20.0f;
		fd.restitution = 0.0f;
		bombBody.createFixture(fd);
	}

	public void SpawnBomb(Vector2 worldPt) {
		bombSpawnPoint = worldPt;
		bombSpawning = true;
	}

	public void MouseMove(Vector2 p) {
		mouseWorld = p;

		if (mouseJoint != null) {
			mouseJoint.setTarget(p);
		}
	}

	@Override
	public void create() {
		camera = new OrthographicCamera(48, 32);
		camera.position.set(0, 15, 0);
		renderer = new Box2DDebugRenderer();
		Vector2 gravity = new Vector2(0.0f, -10.0f);
		boolean doSleep = true;
		world = new World(gravity, doSleep); // һ���׼������
		//creatingGroundBox();
		//creatingDynamicBody();
		Gdx.input.setInputProcessor(this);
	}

	/***
	 * ���������(Creating a Ground Box)
	 */
	private void creatingGroundBox() {
		BodyDef groundBodyDef = new BodyDef(); // �������嶨��
		groundBodyDef.position.set(0.0f, -10.0f);
		// bd.type=BodyType.DynamicBody;
		Body groundBody = world.createBody(groundBodyDef); // ͨ��world����һ������
		PolygonShape groundBox = new PolygonShape();
		groundBox.setAsBox(50.0f, 10.0f);
		groundBody.createFixture(groundBox, 1f);// ����״���ܶȸ�������
	}

	/***
	 * ������̬����(Creating a Dynamic Body)
	 */
	private void creatingDynamicBody() {
		BodyDef bodyDef = new BodyDef(); // �������嶨��
		bodyDef.position.set(0.0f, 4.0f);
		bodyDef.type = BodyType.DynamicBody;
		Body body = world.createBody(bodyDef); // ͨ��world����һ������
		PolygonShape dynamicBox = new PolygonShape();
		dynamicBox.setAsBox(1.0f, 1.0f);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = dynamicBox;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 0.3f;
		body.createFixture(fixtureDef);// ����״���ܶȸ�������
	}

	@Override
	public void dispose() {

		renderer.dispose();
		world.dispose();

		renderer = null;
		world = null;
	}

	@Override
	public void pause() {

	}

	@Override
	public void render() {
		float timeStep = Gdx.app.getGraphics().getDeltaTime();
		int velocityIterations = 6;
		int positionIterations = 2;
		world.step(timeStep, velocityIterations, positionIterations);
		world.clearForces();
		GL10 gl = Gdx.app.getGraphics().getGL10();
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		camera.apply(gl);
		renderer.render(world, camera.combined);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void resume() {

	}

	@Override
	public void beginContact(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		/*final WorldManifold  manifold = contact.getWorldManifold();

		if (manifold.getNumberOfContactPoints() == 0)
		{
			return;
		}

		Fixture fixtureA = contact.getFixtureA();
		Fixture fixtureB = contact.getFixtureB();

		PointState[] state1= new PointState[2];
		PointState[] state2= new PointState[2];
		GetPointStates(state1, state2, oldManifold, manifold);

		WorldManifold worldManifold= contact.getWorldManifold();

		for (int i = 0; i < manifold->pointCount && m_pointCount < k_maxContactPoints; ++i)
		{
			ContactPoint* cp = m_points + m_pointCount;
			cp->fixtureA = fixtureA;
			cp->fixtureB = fixtureB;
			cp->position = worldManifold.points[i];
			cp->normal = worldManifold.normal;
			cp->state = state2[i];
			cp->normalImpulse = manifold->points[i].normalImpulse;
			cp->tangentImpulse = manifold->points[i].tangentImpulse;
			++m_pointCount;
		}*/
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean keyDown(int keycode) {
		Log.i(tag, "keyDown");
		LaunchBomb();
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchMoved(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
