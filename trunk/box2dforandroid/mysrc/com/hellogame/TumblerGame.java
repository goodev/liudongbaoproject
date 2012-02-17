package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;

public class TumblerGame extends Box2DTestGame {

	RevoluteJoint m_joint;
	int m_count = 0;
	private Body groundBody;

	@Override
	public void create() {
		super.create();
		// Ground
		BodyDef groundBodyDef = new BodyDef();
		groundBody = m_world.createBody(groundBodyDef);

		BodyDef bd = new BodyDef();
		bd.type = BodyType.DynamicBody;
		bd.allowSleep = false;
		bd.position.set(0.0f, 10.0f);
		Body body = m_world.createBody(bd);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(0.5f, 10.0f, new Vector2(10.0f, 0.0f), 0.0f);
		body.createFixture(shape, 5.0f);
		shape.setAsBox(0.5f, 10.0f, new Vector2(-10.0f, 0.0f), 0.0f);
		body.createFixture(shape, 5.0f);
		shape.setAsBox(10.0f, 0.5f, new Vector2(0.0f, 10.0f), 0.0f);
		body.createFixture(shape, 5.0f);
		shape.setAsBox(10.0f, 0.5f, new Vector2(0.0f, -10.0f), 0.0f);
		body.createFixture(shape, 5.0f);

		RevoluteJointDef jd = new RevoluteJointDef();
		jd.bodyA = groundBody;
		jd.bodyB = body;
		jd.localAnchorA.set(0.0f, 10.0f);
		jd.localAnchorB.set(0.0f, 0.0f);
		jd.referenceAngle = 0.0f;
		jd.motorSpeed = 0.05f * 3.14159265f;
		jd.maxMotorTorque = 1e8f;
		jd.enableMotor = true;
		m_joint = (RevoluteJoint) m_world.createJoint(jd);
	}

	@Override
	protected void step() {
		super.step();
		if (this.m_count < 600) {
			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(0.0f, 10.0f);
			Body body = m_world.createBody(bd);
			PolygonShape shape = new PolygonShape();
			shape.setAsBox(0.5f, 0.5f);
			body.createFixture(shape, 1.0f);

			++m_count;
		}

	}
}
