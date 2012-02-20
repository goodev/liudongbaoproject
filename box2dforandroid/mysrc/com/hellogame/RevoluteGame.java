package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;

public class RevoluteGame extends Box2DTestGame {
	Body m_ball;
	RevoluteJoint m_joint;

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
			CircleShape shape = new CircleShape();
			shape.setRadius(0.5f);

			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;

			RevoluteJointDef rjd = new RevoluteJointDef();

			bd.position.set(-10.0f, 20.0f);
			Body body = m_world.createBody(bd);
			body.createFixture(shape, 5.0f);

			float w = 100.0f;
			body.setAngularVelocity(w);
			body.setLinearVelocity(new Vector2(-8.0f * w, 0.0f));

			rjd.initialize(ground, body, new Vector2(-10.0f, 12.0f));
			rjd.motorSpeed = 1.0f * b2_pi;
			rjd.maxMotorTorque = 10000.0f;
			rjd.enableMotor = false;
			rjd.lowerAngle = -0.25f * b2_pi;
			rjd.upperAngle = 0.5f * b2_pi;
			rjd.enableLimit = true;
			rjd.collideConnected = true;

			m_joint = (RevoluteJoint) m_world.createJoint(rjd);
		}
		{
			CircleShape circle_shape = new CircleShape();
			circle_shape.setRadius(3f);

			BodyDef circle_bd = new BodyDef();
			circle_bd.type = BodyType.DynamicBody;

			circle_bd.position.set(5.0f, 30.0f);

			FixtureDef fd = new FixtureDef();
			fd.density = 5.0f;
			fd.filter.maskBits = 1;
			fd.shape = circle_shape;

			m_ball = m_world.createBody(circle_bd);
			m_ball.createFixture(fd);

			PolygonShape polygon_shape = new PolygonShape();
			polygon_shape
					.setAsBox(10.0f, 0.2f, new Vector2(-10.0f, 0.0f), 0.0f);

			BodyDef polygon_bd = new BodyDef();
			polygon_bd.position.set(20.0f, 10.0f);
			polygon_bd.type = BodyType.DynamicBody;
			polygon_bd.bullet = true;
			Body polygon_body = m_world.createBody(polygon_bd);
			polygon_body.createFixture(polygon_shape, 2.0f);

			RevoluteJointDef rjd = new RevoluteJointDef();
			rjd.initialize(ground, polygon_body, new Vector2(20.0f, 10.0f));
			rjd.lowerAngle = -0.25f * b2_pi;
			rjd.upperAngle = 0.0f * b2_pi;
			rjd.enableLimit = true;
			m_world.createJoint(rjd);
		}

		// Tests mass computation of a small object far from the origin
		{
			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(20.0f, 15.0f);
			Body body = m_world.createBody(bd);

			PolygonShape polyShape = new PolygonShape();
			Vector2[] verts = new Vector2[3];
			verts[0] = new Vector2(17.63f, 36.31f);
			verts[1] = new Vector2(17.52f, 36.69f);
			verts[2] = new Vector2(17.19f, 36.36f);
			polyShape.set(verts);

			FixtureDef polyFixtureDef = new FixtureDef();
			polyFixtureDef.shape = polyShape;
			polyFixtureDef.density = 1.0f;

			body.createFixture(polyFixtureDef); // assertion hits inside here
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
		}
		return super.keyTyped(character);
	}

	@Override
	protected void step() {
		// settings->viewCenter.x = m_car->GetPosition().x;
		super.step();

	}

}
