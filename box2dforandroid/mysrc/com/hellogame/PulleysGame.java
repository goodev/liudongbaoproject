package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.PulleyJoint;
import com.badlogic.gdx.physics.box2d.joints.PulleyJointDef;

public class PulleysGame extends Box2DTestGame {
	PulleyJoint m_joint1;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		float y = 12.0f;
		float L = 12.0f;
		float a = 1.0f;
		float b = 2.0f;

		Body ground = null;
		{
			BodyDef bd = new BodyDef();
			ground = m_world.createBody(bd);
			EdgeShape shape = new EdgeShape();
			shape.set(new Vector2(-40.0f, 0.0f), new Vector2(40.0f, 0.0f));
			// ground.createFixture(shape, 0.0f);

			CircleShape circle = new CircleShape();
			circle.setRadius(2.0f);

			circle.setPosition(new Vector2(-10.0f, y + b + L));
			ground.createFixture(circle, 0.0f);

			circle.setPosition(new Vector2(10.0f, y + b + L));
			ground.createFixture(circle, 0.0f);
		}
		{

			PolygonShape shape = new PolygonShape();
			shape.setAsBox(a, b);

			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;

			// bd.fixedRotation = true;
			bd.position.set(-10.0f, y);
			Body body1 = m_world.createBody(bd);
			body1.createFixture(shape, 5.0f);

			bd.position.set(10.0f, y);
			Body body2 = m_world.createBody(bd);
			body2.createFixture(shape, 5.0f);

			PulleyJointDef pulleyDef = new PulleyJointDef();
			Vector2 anchor1 = new Vector2(-10.0f, y + b);
			Vector2 anchor2 = new Vector2(10.0f, y + b);
			Vector2 groundAnchor1 = new Vector2(-10.0f, y + b + L);
			Vector2 groundAnchor2 = new Vector2(10.0f, y + b + L);
			pulleyDef.initialize(body1, body2, groundAnchor1, groundAnchor2,
					anchor1, anchor2, 1.5f);

			m_joint1 = (PulleyJoint) m_world.createJoint(pulleyDef);
		}
	}

	@Override
	public boolean keyTyped(char character) {
		switch (character) {
		case 'l':

			break;

		case 'm':

			break;
		}
		return super.keyTyped(character);
	}

	@Override
	protected void step() {
		// settings->viewCenter.x = m_car->GetPosition().x;
		super.step();

	}

}
