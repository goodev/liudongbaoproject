package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJointDef;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;

public class DumpShellGame extends Box2DTestGame {

	@Override
	public void create() {
		super.create();
		Vector2 g = new Vector2(0.000000000000000e+00f, 0.000000000000000e+00f);
		world.setGravity(g);
		Body[] bodies = new Body[3];
		Joint[] joints = new Joint[2];
		createBody0(bodies);
		createBody1(bodies);
		createBody2AndFixture(bodies);
		createJonit0ForBody1AndBody0(bodies, joints);
		createJonit1ForBody1AndBody2(bodies, joints);

	}

	private void createJonit1ForBody1AndBody2(Body[] bodies, Joint[] joints) {
		RevoluteJointDef jd = new RevoluteJointDef();
		jd.bodyA = bodies[1];
		jd.bodyB = bodies[2];
		jd.collideConnected = false;
		jd.localAnchorA.set(0.000000000000000e+00f, 0.000000000000000e+00f);
		jd.localAnchorB.set(8.478260636329651e-01f, 2.500000000000000e+00f);
		jd.referenceAngle = 0.000000000000000e+00f;
		jd.enableLimit = false;
		jd.lowerAngle = 0.000000000000000e+00f;
		jd.upperAngle = 0.000000000000000e+00f;
		jd.enableMotor = false;
		jd.motorSpeed = 0.000000000000000e+00f;
		jd.maxMotorTorque = 0.000000000000000e+00f;
		joints[1] = world.createJoint(jd);
	}

	private void createJonit0ForBody1AndBody0(Body[] bodies, Joint[] joints) {
		PrismaticJointDef jd = new PrismaticJointDef();
		jd.bodyA = bodies[1];
		jd.bodyB = bodies[0];
		jd.collideConnected = false;
		jd.localAnchorA.set(0.000000000000000e+00f, 0.000000000000000e+00f);
		jd.localAnchorB.set(-1.219565200805664e+01f, 0.000000000000000e+00f);
		jd.localAxisA.set(-1.219565200805664e+01f, 0.000000000000000e+00f);
		jd.referenceAngle = 0.000000000000000e+00f;
		jd.enableLimit = true;
		jd.lowerTranslation = -2.000000000000000e+01f;
		jd.upperTranslation = 0.000000000000000e+00f;
		jd.enableMotor = true;
		jd.motorSpeed = 0.000000000000000e+00f;
		jd.maxMotorForce = 1.000000000000000e+01f;
		joints[0] = world.createJoint(jd);
	}

	private void createBody2AndFixture(Body[] bodies) {
		BodyDef bd = new BodyDef();
		bd.type = BodyType.StaticBody;
		bd.position.set(0.000000000000000e+00f, 0.000000000000000e+00f);
		bd.angle = 0.000000000000000e+00f;
		bd.linearVelocity.set(0.000000000000000e+00f, 0.000000000000000e+00f);
		bd.angularVelocity = 0.000000000000000e+00f;
		bd.linearDamping = 0.000000000000000e+00f;
		bd.angularDamping = 0.000000000000000e+00f;
		bd.allowSleep = true;
		bd.awake = true;
		bd.fixedRotation = false;
		bd.bullet = false;
		bd.active = true;
		bd.gravityScale = 1.000000000000000e+00f;
		bodies[2] = world.createBody(bd);
		{
			FixtureDef fd = new FixtureDef();
			fd.friction = 1.000000000000000e+01f;
			fd.restitution = 0.000000000000000e+00f;
			fd.density = 0.000000000000000e+00f;
			fd.isSensor = false;
			fd.filter.categoryBits = 1;
			fd.filter.maskBits = (short) 65535;
			fd.filter.groupIndex = 0;
			EdgeShape shape = new EdgeShape();
			shape.setRadius(9.999999776482582e-03f);
			shape.set(new Vector2(4.452173995971680e+01f,
					1.669565200805664e+01f), new Vector2(
					4.452173995971680e+01f, 0.000000000000000e+00f));
			fd.shape = shape;
			bodies[2].createFixture(fd);
		}
		{
			FixtureDef fd = new FixtureDef();
			fd.friction = 1.000000000000000e+01f;
			fd.restitution = 0.000000000000000e+00f;
			fd.density = 0.000000000000000e+00f;
			fd.isSensor = false;
			fd.filter.categoryBits = 1;
			fd.filter.maskBits = (short) 65535;
			fd.filter.groupIndex = 0;
			EdgeShape shape = new EdgeShape();
			shape.setRadius(9.999999776482582e-03f);
			shape.set(new Vector2(0.000000000000000e+00f,
					1.669565200805664e+01f), new Vector2(
					0.000000000000000e+00f, 0.000000000000000e+00f));
			fd.shape = shape;
			bodies[2].createFixture(fd);

		}
		{
			FixtureDef fd = new FixtureDef();
			fd.friction = 1.000000000000000e+01f;
			fd.restitution = 0.000000000000000e+00f;
			fd.density = 0.000000000000000e+00f;
			fd.isSensor = false;
			fd.filter.categoryBits = 1;
			fd.filter.maskBits = (short) 65535;
			fd.filter.groupIndex = 0;
			EdgeShape shape = new EdgeShape();
			shape.setRadius(9.999999776482582e-03f);
			shape.set(new Vector2(0.000000000000000e+00f,
					1.669565200805664e+01f), new Vector2(
					4.452173995971680e+01f, 1.669565200805664e+01f));
			fd.shape = shape;
			bodies[2].createFixture(fd);
		}
		{
			FixtureDef fd = new FixtureDef();
			fd.friction = 1.000000000000000e+01f;
			fd.restitution = 0.000000000000000e+00f;
			fd.density = 0.000000000000000e+00f;
			fd.isSensor = false;
			fd.filter.categoryBits = 1;
			fd.filter.maskBits = (short) 65535;
			fd.filter.groupIndex = 0;
			EdgeShape shape = new EdgeShape();
			shape.setRadius(9.999999776482582e-03f);
			shape.set(new Vector2(0.000000000000000e+00f,
					0.000000000000000e+00f), new Vector2(
					4.452173995971680e+01f, 0.000000000000000e+00f));
			fd.shape = shape;
			bodies[2].createFixture(fd);

		}
	}

	private void createBody1(Body[] bodies) {

		BodyDef bd = new BodyDef();
		bd.type = BodyType.DynamicBody;
		bd.position.set(8.478260636329651e-01f, 2.500000000000000e+00f);
		bd.angle = 0.000000000000000e+00f;
		bd.linearVelocity.set(0.000000000000000e+00f, 0.000000000000000e+00f);
		bd.angularVelocity = 0.000000000000000e+00f;
		bd.linearDamping = 5.000000000000000e-01f;
		bd.angularDamping = 5.000000000000000e-01f;
		bd.allowSleep = true;
		bd.awake = true;
		bd.fixedRotation = false;
		bd.bullet = false;
		bd.active = true;
		bd.gravityScale = 1.000000000000000e+00f;
		bodies[1] = world.createBody(bd);

		FixtureDef fd = new FixtureDef();
		fd.friction = 1.000000000000000e+00f;
		fd.restitution = 5.000000000000000e-01f;
		fd.density = 1.000000000000000e+01f;
		fd.isSensor = false;
		fd.filter.categoryBits = 1;
		fd.filter.maskBits = (short) 65535;
		fd.filter.groupIndex = 0;
		PolygonShape shape = new PolygonShape();
		Vector2[] vs = new Vector2[4];
		vs[0] = new Vector2(-3.228000104427338e-01f, -2.957000136375427e-01f);
		vs[1] = new Vector2(6.885900020599365e+00f, -3.641000092029572e-01f);
		vs[2] = new Vector2(6.907599925994873e+00f, 3.271999955177307e-01f);
		vs[3] = new Vector2(-3.228000104427338e-01f, 2.825999855995178e-01f);
		shape.set(vs);

		fd.shape = shape;

		bodies[1].createFixture(fd);

	}

	private void createBody0(Body[] bodies) {
		BodyDef bd = new BodyDef();
		bd.type = BodyType.DynamicBody;
		bd.position.set(1.304347801208496e+01f, 2.500000000000000e+00f);
		bd.angle = 0.000000000000000e+00f;
		bd.linearVelocity.set(0.000000000000000e+00f, 0.000000000000000e+00f);
		bd.angularVelocity = 0.000000000000000e+00f;
		bd.linearDamping = 5.000000000000000e-01f;
		bd.angularDamping = 5.000000000000000e-01f;
		bd.allowSleep = true;
		bd.awake = true;
		bd.fixedRotation = false;
		bd.bullet = false;
		bd.active = true;
		bd.gravityScale = 1.000000000000000e+00f;
		bodies[0] = world.createBody(bd);

		FixtureDef fd = new FixtureDef();
		fd.friction = 1.000000000000000e+00f;
		fd.restitution = 5.000000000000000e-01f;
		fd.density = 1.000000000000000e+01f;
		fd.isSensor = false;
		fd.filter.categoryBits = 1;
		fd.filter.maskBits = (short) 65535;
		fd.filter.groupIndex = 0;
		PolygonShape shape = new PolygonShape();
		Vector2[] vs = new Vector2[4];
		vs[0] = new Vector2(-6.900000095367432e+00f, -3.000000119209290e-01f);
		vs[1] = new Vector2(2.000000029802322e-01f, -3.000000119209290e-01f);
		vs[2] = new Vector2(2.000000029802322e-01f, 2.000000029802322e-01f);
		vs[3] = new Vector2(-6.900000095367432e+00f, 2.000000029802322e-01f);
		shape.set(vs);
		fd.shape = shape;
		bodies[0].createFixture(fd);
	}

}
