package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Transform;
import com.badlogic.gdx.physics.box2d.joints.FrictionJointDef;

//This is a fun demo that shows off the wheel joint
public class ApplyForceGame extends Box2DTestGame {
	Body m_body;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		world.setGravity(new Vector2(0.0f, 0.0f));

		final float k_restitution = 0.4f;

		Body ground;
		{
			BodyDef bd = new BodyDef();
			bd.position.set(0.0f, 20.0f);
			ground = world.createBody(bd);

			EdgeShape shape = new EdgeShape();

			FixtureDef sd = new FixtureDef();
			sd.shape = shape;
			sd.density = 0.0f;
			sd.restitution = k_restitution;

			// Left vertical
			shape.set(new Vector2(-20.0f, -20.0f), new Vector2(-20.0f, 20.0f));
			ground.createFixture(sd);

			// Right vertical
			shape.set(new Vector2(20.0f, -20.0f), new Vector2(20.0f, 20.0f));
			ground.createFixture(sd);

			// Top horizontal
			shape.set(new Vector2(-20.0f, 20.0f), new Vector2(20.0f, 20.0f));
			ground.createFixture(sd);

			// Bottom horizontal
			shape.set(new Vector2(-20.0f, -20.0f), new Vector2(20.0f, -20.0f));
			ground.createFixture(sd);
		}

		{
			Transform xf1 = new Transform();
			xf1.setRotation((0.3524f * b2_pi));
			xf1.setPosition(new Vector2(xf1.vals[Transform.SIN], 0.0f));

			Vector2[] vertices = new Vector2[3];
			vertices[0] = xf1.mul(new Vector2(-1.0f, 0.0f));
			vertices[1] = xf1.mul(new Vector2(1.0f, 0.0f));
			vertices[2] = xf1.mul(new Vector2(0.0f, 0.5f));

			PolygonShape poly1 = new PolygonShape();
			poly1.set(vertices);

			FixtureDef sd1 = new FixtureDef();
			sd1.shape = poly1;
			sd1.density = 4.0f;

			Transform xf2 = new Transform();
			xf2.setRotation(-0.3524f * b2_pi);
			xf2.setPosition(new Vector2(-xf2.vals[Transform.SIN], 0.0f));

			vertices[0] = xf2.mul(new Vector2(-1.0f, 0.0f));
			vertices[1] = xf2.mul(new Vector2(1.0f, 0.0f));
			vertices[2] = xf2.mul(new Vector2(0.0f, 0.5f));

			PolygonShape poly2 = new PolygonShape();
			poly2.set(vertices);

			FixtureDef sd2 = new FixtureDef();
			;
			sd2.shape = poly2;
			sd2.density = 2.0f;

			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.angularDamping = 5.0f;
			bd.linearDamping = 0.1f;

			bd.position.set(0.0f, 2.0f);
			bd.angle = b2_pi;
			bd.allowSleep = false;
			m_body = world.createBody(bd);
			m_body.createFixture(sd1);
			m_body.createFixture(sd2);
		}

		{
			PolygonShape shape = new PolygonShape();
			shape.setAsBox(0.5f, 0.5f);

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 1.0f;
			fd.friction = 0.3f;

			for (int i = 0; i < 10; ++i) {
				BodyDef bd = new BodyDef();
				bd.type = BodyType.DynamicBody;

				bd.position.set(0.0f, 5.0f + 1.54f * i);
				Body body = world.createBody(bd);

				body.createFixture(fd);

				float gravity = 10.0f;
				float I = body.getInertia();
				float mass = body.getMass();

				// For a circle: I = 0.5 m r r ==> r = sqrt(2 I / m)
				float radius = (float) Math.sqrt(2.0f * I / mass);

				FrictionJointDef jd = new FrictionJointDef();
				jd.localAnchorA.set(0.0f, 0.0f);
				jd.localAnchorB.set(0.0f, 0.0f);
				jd.bodyA = ground;
				jd.bodyB = body;
				jd.collideConnected = true;
				jd.maxForce = mass * gravity;
				jd.maxTorque = mass * radius * gravity;

				world.createJoint(jd);
			}
		}

	}

	@Override
	public boolean keyTyped(char character) {
		switch (character) {
		case 'w': {
			Vector2 f = m_body.getWorldVector(new Vector2(0.0f, -200.0f));
			Vector2 p = m_body.getWorldPoint(new Vector2(0.0f, 2.0f));
			m_body.applyForce(f, p);
		}
			break;

		case 'a': {
			m_body.applyTorque(50.0f);
		}
			break;

		case 'd': {
			m_body.applyTorque(-50.0f);
		}
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
