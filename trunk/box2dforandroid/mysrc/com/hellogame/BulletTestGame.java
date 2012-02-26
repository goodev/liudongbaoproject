package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class BulletTestGame extends Box2DTestGame {
	Body m_body;
	Body m_bullet;
	float m_x;

	@Override
	public void create() {
		super.create();
		{
			BodyDef bd = new BodyDef();
			bd.position.set(0.0f, 0.0f);
			Body body = m_world.createBody(bd);

			EdgeShape edge = new EdgeShape();

			edge.set(new Vector2(-10.0f, 0.0f), new Vector2(10.0f, 0.0f));
			body.createFixture(edge, 0.0f);

			PolygonShape shape = new PolygonShape();
			shape.setAsBox(0.2f, 1.0f, new Vector2(0.5f, 1.0f), 0.0f);
			body.createFixture(shape, 0.0f);
		}
		{
			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(0.0f, 4.0f);

			PolygonShape box = new PolygonShape();
			box.setAsBox(2.0f, 0.1f);

			m_body = m_world.createBody(bd);
			m_body.createFixture(box, 1.0f);

			box.setAsBox(0.25f, 0.25f);

			// m_x = RandomFloat(-1.0f, 1.0f);
			m_x = 0.20352793f;
			bd.position.set(m_x, 10.0f);
			bd.bullet = true;

			m_bullet = m_world.createBody(bd);
			m_bullet.createFixture(box, 100.0f);

			m_bullet.setLinearVelocity(new Vector2(0.0f, -50.0f));
		}
	}

	void Launch() {
		m_body.setTransform(new Vector2(0.0f, 4.0f), 0.0f);
		m_body.setLinearVelocity(new Vector2(0.0f, 0.0f));
		m_body.setAngularVelocity(0.0f);

		m_x = (float) Math.random();
		m_bullet.setTransform(new Vector2(m_x, 10.0f), 0.0f);
		m_bullet.setLinearVelocity(new Vector2(0.0f, -50.0f));
		m_bullet.setAngularVelocity(0.0f);

		int b2_gjkCalls, b2_gjkIters, b2_gjkMaxIters;
		int b2_toiCalls, b2_toiIters, b2_toiMaxIters;
		int b2_toiRootIters, b2_toiMaxRootIters;

		b2_gjkCalls = 0;
		b2_gjkIters = 0;
		b2_gjkMaxIters = 0;

		b2_toiCalls = 0;
		b2_toiIters = 0;
		b2_toiMaxIters = 0;
		b2_toiRootIters = 0;
		b2_toiMaxRootIters = 0;
	}

	@Override
	public boolean keyTyped(char character) {
		switch (character) {
		case 'a':

			break;
		}
		return super.keyTyped(character);
	}

	@Override
	protected void step() {
		super.step();
		if (stepCount % 60 == 0)
		{
			Launch();
		}
	}

 

}
