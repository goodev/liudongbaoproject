package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJoint;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJointDef;

//The motor in this test gets smoother with higher velocity iterations.
public class PrismaticGame extends Box2DTestGame {
	PrismaticJoint m_joint = null;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		m_world.setGravity(new Vector2(0.0f, 0.0f));

		Body ground;
		{
			BodyDef bd = new BodyDef();
			ground = m_world.createBody(bd);
			EdgeShape shape = new EdgeShape();
			shape.set(new Vector2(-40.0f, 0.0f), new Vector2(40.0f, 0.0f));
			ground.createFixture(shape, 0.0f);
		}

		{
			PolygonShape shape = new PolygonShape();
			shape.setAsBox(2.0f, 0.5f);

			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(-10.0f, 10.0f);
			bd.angle = 0.5f * b2_pi;
			bd.allowSleep = false;
			Body body = m_world.createBody(bd);
			body.createFixture(shape, 5.0f);

			PrismaticJointDef pjd = new PrismaticJointDef();

			// Bouncy limit
			Vector2 axis = new Vector2(2.0f, 1.0f);
			axis.nor();
			pjd.initialize(ground, body, new Vector2(0.0f, 0.0f), axis);

			// Non-bouncy limit
			// pjd.Initialize(ground, body, b2Vec2(-10.0f, 10.0f), b2Vec2(1.0f,
			// 0.0f));

			pjd.motorSpeed = 10.0f;
			pjd.maxMotorForce = 10000.0f;
			pjd.enableMotor = true;
			pjd.lowerTranslation = 0.0f;
			pjd.upperTranslation = 20.0f;
			pjd.enableLimit = true;

			m_joint = (PrismaticJoint) m_world.createJoint(pjd);
		}
	}

	@Override
	public boolean keyTyped(char character) {
		switch (character) {
		case 'l':
			m_joint.enableLimit(!m_joint.isLimitEnabled());
			break;

		case 'm':
			m_joint.enableMotor(!m_joint.isMotorEnabled());
			break;

		case 's':
			m_joint.setMotorSpeed(-m_joint.getMotorSpeed());
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
