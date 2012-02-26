package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class ContinuousTestGame extends Box2DTestGame {
	Body m_body;

	float m_angularVelocity;

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
			bd.position.set(0.0f, 20.0f);
			// bd.angle = 0.1f;

			PolygonShape shape = new PolygonShape();
			shape.setAsBox(2.0f, 0.1f);

			m_body = m_world.createBody(bd);
			m_body.createFixture(shape, 1.0f);

			m_angularVelocity = RandomFloat();
			// m_angularVelocity = 46.661274f;
			m_body.setLinearVelocity(new Vector2(0.0f, -100.0f));
			m_body.setAngularVelocity(m_angularVelocity);
		}
	}

	void Launch() {
		m_body.setTransform(new Vector2(0.0f, 20.0f), 0.0f);
		m_body.setLinearVelocity(new Vector2(0.0f, -100f));
		m_body.setAngularVelocity(RandomFloat());

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
		if (stepCount % 60 == 0) {
			//Launch();
		}
	}

}
