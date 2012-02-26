package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;

/// This tests bullet collision and provides an example of a gameplay scenario.
/// This also uses a loop shape.

public class PinballGame extends Box2DTestGame {
	RevoluteJoint m_leftJoint;
	RevoluteJoint m_rightJoint;
	Body m_ball;
	boolean m_button;

	@Override
	public void create() {
		super.create();

		Body ground = null;
		{
			BodyDef bd = new BodyDef();
			ground = m_world.createBody(bd);
			Vector2[] vs = new Vector2[5];
			vs[0] = new Vector2(0.0f, -2.0f);
			vs[1] = new Vector2(8.0f, 6.0f);
			vs[2] = new Vector2(8.0f, 20.0f);
			vs[3] = new Vector2(-8.0f, 20.0f);
			vs[4] = new Vector2(-8.0f, 6.0f);
			ChainShape loop = new ChainShape();
			loop.createLoop(vs);
			FixtureDef fd = new FixtureDef();
			fd.shape = loop;
			fd.density = 0.0f;
			ground.createFixture(fd);

		}
		// Flippers
		{
			Vector2 p1 = new Vector2(-2.0f, 0.0f);
			Vector2 p2 = new Vector2(2.0f, 0.0f);

			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;

			bd.position.set(p1);
			Body leftFlipper = m_world.createBody(bd);

			bd.position.set(p2);
			Body rightFlipper = m_world.createBody(bd);

			PolygonShape box = new PolygonShape();
			box.setAsBox(1.75f, 0.1f);

			FixtureDef fd = new FixtureDef();
			fd.shape = box;
			fd.density = 1.0f;

			leftFlipper.createFixture(fd);
			rightFlipper.createFixture(fd);

			RevoluteJointDef jd = new RevoluteJointDef();
			jd.bodyA = ground;
			jd.localAnchorB.set(0f, 0f);
			jd.enableMotor = true;
			jd.maxMotorTorque = 1000.0f;
			jd.enableLimit = true;

			jd.motorSpeed = 0.0f;
			jd.localAnchorA.set(p1);
			jd.bodyB = leftFlipper;
			jd.lowerAngle = -30.0f * b2_pi / 180.0f;
			jd.upperAngle = 5.0f * b2_pi / 180.0f;
			m_leftJoint = (RevoluteJoint) m_world.createJoint(jd);

			jd.motorSpeed = 0.0f;
			jd.localAnchorA.set(p2);
			jd.bodyB = rightFlipper;
			jd.lowerAngle = -5.0f * b2_pi / 180.0f;
			jd.upperAngle = 30.0f * b2_pi / 180.0f;
			m_rightJoint = (RevoluteJoint) m_world.createJoint(jd);
		}
		// Circle character
		{
			BodyDef bd = new BodyDef();
			bd.position.set(1.0f, 15.0f);
			bd.type = BodyType.DynamicBody;
			bd.bullet = true;

			m_ball = m_world.createBody(bd);

			CircleShape shape = new CircleShape();
			shape.setRadius(.2f);

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 1.0f;
			m_ball.createFixture(fd);
		}

		m_button = false;
	}

	@Override
	public boolean keyTyped(char character) {
		switch (character) {
		case 'a':
		case 'A':
			m_button = !m_button;
			break;
		}
		return super.keyTyped(character);
	}

	@Override
	protected void step() {

		if (m_button) {
			m_leftJoint.setMotorSpeed(20.0f);
			m_rightJoint.setMotorSpeed(-20.0f);
		} else {
			m_leftJoint.setMotorSpeed(-10.0f);
			m_rightJoint.setMotorSpeed(10.0f);
		}

		super.step();

	}

/*	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case 'a':
		case 'A':
			m_button = false;
			break;
		}
		return super.keyUp(keycode);
	}*/

}
