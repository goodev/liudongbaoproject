package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;

public class TilesGame extends Box2DTestGame {

	int m_fixtureCount;
	float m_createTime;
	private Body groundBody;

	@Override
	public void create() {
		super.create();
		// Ground
		createGroundTypes();
		createTestTypes();
		m_createTime = System.currentTimeMillis();
	}
	private void createGroundTypes() {
		float a = 0.5f;
		BodyDef groundBodyDef = new BodyDef();
		groundBodyDef.position.y = -a;
		groundBody = world.createBody(groundBodyDef);
		int N = 200;
		int M = 10;
		Vector2 position = new Vector2();
		position.y = 0.0f;
		for (int j = 0; j < M; ++j) {
			position.x = -N * a;
			for (int i = 0; i < N; ++i) {
				PolygonShape shape = new PolygonShape();
				shape.setAsBox(a, a, position, 0.0f);
				groundBody.createFixture(shape, 0.0f);
				++m_fixtureCount;
				position.x += 2.0f * a;
			}
			position.y -= 2.0f * a;
		}
	}
	private void createTestTypes() {
		{
			float a = 0.5f;
			PolygonShape shape = new PolygonShape();
			shape.setAsBox(a, a);

			Vector2 x = new Vector2(-7.0f, 0.75f);
			Vector2 y = null;
			Vector2 deltaX = new Vector2(0.5625f, 1.25f);
			Vector2 deltaY = new Vector2(1.125f, 0.0f);

			for (int i = 0; i < 20; ++i) {
				y = x;

				for (int j = i; j < 20; ++j) {
					BodyDef bd = new BodyDef();
					bd.type = BodyType.DynamicBody;
					bd.position.set(y);
					Body body = world.createBody(bd);
					body.createFixture(shape, 5.0f);
					++m_fixtureCount;
					y.add(deltaY);
				}

				x.add(deltaX);
			}
		}
	}



	@Override
	protected void step() {
		super.step();

	}
}
