package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class ShapeEditingGame extends Box2DTestGame {

	Body m_body;
	Fixture m_fixture1;
	Fixture m_fixture2;
	boolean m_sensor;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		{
			BodyDef bd = new BodyDef();
			Body ground = m_world.createBody(bd);

			EdgeShape shape = new EdgeShape();
			shape.set(new Vector2(-40.0f, 0.0f), new Vector2(40.0f, 0.0f));

			ground.createFixture(shape, 0.0f);
		}

		BodyDef bd = new BodyDef();
		bd.type = BodyType.DynamicBody;
		bd.position.set(0.0f, 10.0f);
		m_body = m_world.createBody(bd);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(4.0f, 4.0f, new Vector2(0.0f, 0.0f), 0.0f);
		m_fixture1 = m_body.createFixture(shape, 10.0f);

		m_fixture2 = null;

		m_sensor = false;
	}

	@Override
	public boolean keyTyped(char character) {
		switch (character) {
		case 'c':
			if (m_fixture2 == null) {
				CircleShape shape = new CircleShape();
				shape.setRadius(3.0f);
				shape.setPosition(new Vector2(0.5f, -4.0f));
				m_fixture2 = m_body.createFixture(shape, 10.0f);
				m_body.setAwake(true);
			}
			break;

		case 'd':
			if (m_fixture2 != null) {
				m_body.destroyFixture(m_fixture2);
				m_fixture2 = null;
				m_body.setAwake(true);
			}
			break;

		case 's':
			if (m_fixture2 != null) {
				m_sensor = !m_sensor;
				m_fixture2.setSensor(m_sensor);
			}
			break;
		}
		return super.keyTyped(character);
	}

}
