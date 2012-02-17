package com.hellogame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * ��Ӧ Box2D+v2.1.0�û��ֲ����� ������
 * 
 * @author liudongbao
 * 
 */
public class HelloBox2DCollisionModuleGame implements ApplicationListener {

	protected OrthographicCamera camera;
	protected Box2DDebugRenderer renderer; // �����û�����
	private World world;

	@Override
	public void create() {
		camera = new OrthographicCamera(48, 32);
		camera.position.set(0, 15, 0);
		renderer = new Box2DDebugRenderer();
		Vector2 gravity = new Vector2(0.0f, -10.0f);
		boolean doSleep = true;
		world = new World(gravity, doSleep); // һ���׼������
		creatingGroundBox();
		creatingCircleShape();
		creatingPolygonShape();
		//creatingDynamicBody();
	}

	private void creatingPolygonShape() {
		// TODO Auto-generated method stub
		// ����ʱ��˳����һ�������
		/*
		 * b2Vec2 vertices[3]; vertices[0].Set(0.0f, 0.0f);
		 * vertices[1].Set(1.0f, 0.0f); vertices[2].Set(0.0f, 1.0f); int32 count
		 * = 3;
		 * 
		 * b2PolygonShape polygon; polygon.Set(vertices, count);
		 * �������һЩ����õĳ�ʼ��������������(box)�ͱ�(edge,Ҳ�����߶�)�� void SetAsBox(float32 hx,
		 * float32hy); void SetAsBox(float32 hx, float32hy, const b2Vec2&
		 * center, float32 angle); void SetAsEdge(const b2Vec2& v1,const b2Vec2&
		 * v2);
		 */

		BodyDef bodyDef = new BodyDef(); // �������嶨��
		bodyDef.position.set(0.0f, 0.0f);
		bodyDef.type = BodyType.DynamicBody;
		Body body = world.createBody(bodyDef); // ͨ��m_world����һ������
		PolygonShape shape = new PolygonShape();
		Vector2[] vector2s = { new Vector2(0.0f, 0.0f),
				new Vector2(1.0f, 0.0f), new Vector2(0.0f, 1.0f) };
		shape.set(vector2s);
		shape.setRadius(1f);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 1.0f;
		body.createFixture(fixtureDef);// ����״���ܶȸ�������
	}

	private void creatingCircleShape() {
		// TODO Auto-generated method stub
		/*
		 * b2CircleShape circle; circle.m_p.Set(1.0f, 2.0f, 3.0f);
		 * circle.m_radius = 0.5f;
		 */
		BodyDef bodyDef = new BodyDef(); // �������嶨��
		bodyDef.position.set(0.0f, 4.0f);
		bodyDef.type = BodyType.DynamicBody;
		Body body = world.createBody(bodyDef); // ͨ��m_world����һ������
		CircleShape circle = new CircleShape();
		circle.setPosition(new Vector2(1.0f, 2.0f));
		circle.setRadius(0.5f);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 1.0f;
		body.createFixture(fixtureDef);// ����״���ܶȸ�������
	}

	/***
	 * ���������(Creating a Ground Box)
	 */
	private void creatingGroundBox() {
		BodyDef groundBodyDef = new BodyDef(); // �������嶨��
		groundBodyDef.position.set(0.0f, -10.0f);
		// bd.type=BodyType.DynamicBody;
		Body groundBody = world.createBody(groundBodyDef); // ͨ��m_world����һ������
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
		Body body = world.createBody(bodyDef); // ͨ��m_world����һ������
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
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}