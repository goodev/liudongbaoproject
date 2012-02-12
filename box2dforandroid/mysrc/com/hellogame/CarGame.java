package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.badlogic.gdx.physics.box2d.joints.WheelJoint;
import com.badlogic.gdx.physics.box2d.joints.WheelJointDef;

//This is a fun demo that shows off the wheel joint
public class CarGame extends Box2DTestGame {
	Body m_car;
	Body m_wheel1;
	Body m_wheel2;

	float m_hz;
	float m_zeta;
	float m_speed;
	WheelJoint m_spring1 = null;
	WheelJoint m_spring2 = null;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		m_hz = 4.0f;
		m_zeta = 0.7f;
		m_speed = 50.0f;

		Body ground = null;
		// Ground
		{
			BodyDef bd = new BodyDef();
			ground = world.createBody(bd);
			EdgeShape shape = new EdgeShape();

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 0.0f;
			fd.friction = 0.6f;

			shape.set(new Vector2(-20.0f, 0.0f), new Vector2(20.0f, 0.0f));
			ground.createFixture(fd);

			float[] hs = { 0.25f, 1.0f, 4.0f, 0.0f, 0.0f, -1.0f, -2.0f, -2.0f,
					-1.25f, 0.0f };

			float x = 20.0f, y1 = 0.0f, dx = 5.0f;

			for (int i = 0; i < 10; ++i) {
				float y2 = hs[i];
				shape.set(new Vector2(x, y1), new Vector2(x + dx, y2));
				ground.createFixture(fd);
				y1 = y2;
				x += dx;
			}

			for (int i = 0; i < 10; ++i) {
				float y2 = hs[i];
				shape.set(new Vector2(x, y1), new Vector2(x + dx, y2));
				ground.createFixture(fd);
				y1 = y2;
				x += dx;
			}

			shape.set(new Vector2(x, 0.0f), new Vector2(x + 40.0f, 0.0f));
			ground.createFixture(fd);

			x += 80.0f;
			shape.set(new Vector2(x, 0.0f), new Vector2(x + 40.0f, 0.0f));
			ground.createFixture(fd);

			x += 40.0f;
			shape.set(new Vector2(x, 0.0f), new Vector2(x + 10.0f, 5.0f));
			ground.createFixture(fd);

			x += 20.0f;
			shape.set(new Vector2(x, 0.0f), new Vector2(x + 40.0f, 0.0f));
			ground.createFixture(fd);

			x += 40.0f;
			shape.set(new Vector2(x, 0.0f), new Vector2(x, 20.0f));
			ground.createFixture(fd);
		}
		// Teeter
		{
			BodyDef bd = new BodyDef();
			bd.position.set(140.0f, 1.0f);
			bd.type = BodyType.DynamicBody;
			Body body = world.createBody(bd);

			PolygonShape box = new PolygonShape();
			box.setAsBox(10.0f, 0.25f);
			body.createFixture(box, 1.0f);

			RevoluteJointDef jd = new RevoluteJointDef();
			jd.initialize(ground, body, body.getPosition());
			jd.lowerAngle = -8.0f * b2_pi / 180.0f;
			jd.upperAngle = 8.0f * b2_pi / 180.0f;
			jd.enableLimit = true;
			world.createJoint(jd);
			body.applyAngularImpulse(100.0f);
		}

		// Bridge
		{
			int N = 20;
			PolygonShape shape = new PolygonShape();
			shape.setAsBox(1.0f, 0.125f);

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 1.0f;
			fd.friction = 0.6f;

			RevoluteJointDef jd = new RevoluteJointDef();

			Body prevBody = ground;
			for (int i = 0; i < N; ++i) {
				BodyDef bd = new BodyDef();
				bd.type = BodyType.DynamicBody;
				bd.position.set(161.0f + 2.0f * i, -0.125f);
				Body body = world.createBody(bd);
				body.createFixture(fd);

				Vector2 anchor = new Vector2(160.0f + 2.0f * i, -0.125f);
				jd.initialize(prevBody, body, anchor);
				world.createJoint(jd);

				prevBody = body;
			}

			Vector2 anchor = new Vector2(160.0f + 2.0f * N, -0.125f);
			jd.initialize(prevBody, ground, anchor);
			world.createJoint(jd);
		}
		// Boxes
		{
			PolygonShape box = new PolygonShape();
			box.setAsBox(0.5f, 0.5f);

			Body body = null;
			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;

			bd.position.set(230.0f, 0.5f);
			body = world.createBody(bd);
			body.createFixture(box, 0.5f);

			bd.position.set(230.0f, 1.5f);
			body = world.createBody(bd);
			body.createFixture(box, 0.5f);

			bd.position.set(230.0f, 2.5f);
			body = world.createBody(bd);
			body.createFixture(box, 0.5f);

			bd.position.set(230.0f, 3.5f);
			body = world.createBody(bd);
			body.createFixture(box, 0.5f);

			bd.position.set(230.0f, 4.5f);
			body = world.createBody(bd);
			body.createFixture(box, 0.5f);
		}

		// Car
		{
			PolygonShape chassis = new PolygonShape();
			Vector2[] vertices = new Vector2[6];
			vertices[0] = new Vector2(-1.5f, -0.5f);
			vertices[1] = new Vector2(1.5f, -0.5f);
			vertices[2] = new Vector2(1.5f, 0.0f);
			vertices[3] = new Vector2(0.0f, 0.9f);
			vertices[4] = new Vector2(-1.15f, 0.9f);
			vertices[5] = new Vector2(-1.5f, 0.2f);
			chassis.set(vertices);

			CircleShape circle = new CircleShape();
			circle.setRadius(0.4f);

			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(0.0f, 1.0f);
			m_car = world.createBody(bd);
			m_car.createFixture(chassis, 1.0f);

			FixtureDef fd = new FixtureDef();
			fd.shape = circle;
			fd.density = 1.0f;
			fd.friction = 0.9f;

			bd.position.set(-1.0f, 0.35f);
			m_wheel1 = world.createBody(bd);
			m_wheel1.createFixture(fd);

			bd.position.set(1.0f, 0.4f);
			m_wheel2 = world.createBody(bd);
			m_wheel2.createFixture(fd);

			WheelJointDef jd = new WheelJointDef();
			Vector2 axis = new Vector2(0.0f, 1.0f);

			jd.initialize(m_car, m_wheel1, m_wheel1.getPosition(), axis);
			jd.motorSpeed = 0.0f;
			jd.maxMotorTorque = 20.0f;
			jd.enableMotor = true;
			jd.frequencyHz = m_hz;
			jd.dampingRatio = m_zeta;
			m_spring1 = (WheelJoint) world.createJoint(jd);

			jd.initialize(m_car, m_wheel2, m_wheel2.getPosition(), axis);
			jd.motorSpeed = 0.0f;
			jd.maxMotorTorque = 10.0f;
			jd.enableMotor = false;
			jd.frequencyHz = m_hz;
			jd.dampingRatio = m_zeta;
			m_spring2 = (WheelJoint) world.createJoint(jd);
		}
	}

	@Override
	public boolean keyTyped(char character) {
		switch (character) {
		case 'a':
			m_spring1.setMotorSpeed(m_speed);
			break;

		case 's':
			m_spring1.setMotorSpeed(0.0f);
			break;

		case 'd':
			m_spring1.setMotorSpeed(-m_speed);
			break;

		case 'q':
			m_hz = Math.max(0.0f, m_hz - 1.0f);
			m_spring1.setSpringFrequencyHz(m_hz);
			m_spring2.setSpringFrequencyHz(m_hz);
			break;

		case 'e':
			m_hz += 1.0f;
			m_spring1.setSpringFrequencyHz(m_hz);
			m_spring2.setSpringFrequencyHz(m_hz);
			break;
		}
		return super.keyTyped(character);
	}

}
