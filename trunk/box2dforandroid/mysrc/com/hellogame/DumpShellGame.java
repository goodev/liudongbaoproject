package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class DumpShellGame extends Box2DTestGame {

	@Override
	public void create() {
		super.create();
		Vector2 g = new Vector2(0.000000000000000e+00f, 0.000000000000000e+00f);
		world.setGravity(g);
		Body[] bodies = new Body[3];
		Joint[] joints = new Joint[2];
		create0Body(bodies);
		create1Body(bodies);
	}

	private void create1Body(Body[] bodies) {

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

	private void create0Body(Body[] bodies) {
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
