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
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class HelloBox2DGame implements ApplicationListener {

	protected OrthographicCamera camera;
	protected Box2DDebugRenderer renderer; // 测试用绘制器
	private World world;

	@Override
	public void create() {
		camera = new OrthographicCamera(48, 32);
		camera.position.set(0, 15, 0);
		renderer = new Box2DDebugRenderer();
		Vector2 gravity = new Vector2(0.0f, -10.0f);
		boolean doSleep = true;

		world = new World(gravity, doSleep); // 一般标准重力场
		creatingGroundBox();
		creatingDynamicBody();
	}

	/***
	 * 创建地面盒(Creating a Ground Box)
	 */
	private void creatingGroundBox() {
		BodyDef groundBodyDef = new BodyDef(); // 声明物体定义
		groundBodyDef.position.set(0.0f, -10.0f);
		// bd.type=BodyType.DynamicBody;
		Body groundBody = world.createBody(groundBodyDef); // 通过world创建一个物体
		PolygonShape groundBox = new PolygonShape();
		groundBox.setAsBox(50.0f, 10.0f);
		groundBody.createFixture(groundBox, 1f);// 将形状和密度赋给物体
	}
	/***
	 * 创建动态物体(Creating a Dynamic Body)
	 */
	private void creatingDynamicBody() {
		BodyDef bodyDef = new BodyDef(); // 声明物体定义
		bodyDef.position.set(0.0f, 4.0f);
		bodyDef.type=BodyType.DynamicBody;
		Body body = world.createBody(bodyDef); // 通过world创建一个物体
		PolygonShape dynamicBox = new PolygonShape();
		dynamicBox.setAsBox(1.0f, 1.0f);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape =dynamicBox;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 0.3f;
		body.createFixture(fixtureDef);// 将形状和密度赋给物体
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
		world.step(timeStep,velocityIterations, positionIterations);
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