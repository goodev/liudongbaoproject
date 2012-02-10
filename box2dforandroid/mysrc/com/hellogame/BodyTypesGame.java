package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJointDef;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;

public class BodyTypesGame extends Box2DTestGame {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		Body ground = null, m_attachment = null, m_platform = null;
		{
			BodyDef bd = new BodyDef();
			ground = world.createBody(bd);

			EdgeShape shape = new EdgeShape();
			shape.set(new Vector2(-20.0f, 0.0f), new Vector2(20.0f, 0.0f));

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;

			ground.createFixture(fd);
		}
		// Define attachment
		{
			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(0.0f, 3.0f);
			m_attachment = world.createBody(bd);

			PolygonShape shape = new PolygonShape();
			shape.setAsBox(0.5f, 2.0f);
			m_attachment.createFixture(shape, 2.0f);
		}
		// Define platform
		{
			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(-4.0f, 5.0f);
			m_platform = world.createBody(bd);

			PolygonShape shape = new PolygonShape();
			shape.setAsBox(0.5f, 4.0f, new Vector2(4.0f, 0.0f), 0.5f * b2_pi);

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.friction = 0.6f;
			fd.density = 2.0f;
			m_platform.createFixture(fd);

			RevoluteJointDef rjd = new RevoluteJointDef();
			rjd.initialize(m_attachment, m_platform, new Vector2(0.0f, 5.0f));
			rjd.maxMotorTorque = 50.0f;
			rjd.enableMotor = true;
			world.createJoint(rjd);

			PrismaticJointDef pjd = new PrismaticJointDef();
			pjd.initialize(ground, m_platform, new Vector2(0.0f, 5.0f),
					new Vector2(1.0f, 0.0f));

			pjd.maxMotorForce = 1000.0f;
			pjd.enableMotor = true;
			pjd.lowerTranslation = -10.0f;
			pjd.upperTranslation = 10.0f;
			pjd.enableLimit = true;

			world.createJoint(pjd);

		}
		// Create a payload
		{
			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(0.0f, 8.0f);
			Body body = world.createBody(bd);

			PolygonShape shape = new PolygonShape();
			shape.setAsBox(0.75f, 0.75f);

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.friction = 0.6f;
			fd.density = 2.0f;

			body.createFixture(fd);
		}
	}
}
