package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJoint;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJointDef;

public class SphereStackGame extends Box2DTestGame {
	final int e_count = 10;
	Body[] m_bodies = new Body[e_count];

	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		Body ground;
		{
			BodyDef bd = new BodyDef();
			ground = m_world.createBody(bd);
			EdgeShape shape = new EdgeShape();
			shape.set(new Vector2(-40.0f, 0.0f), new Vector2(40.0f, 0.0f));
			ground.createFixture(shape, 0.0f);

		}
		CircleShape shape = new CircleShape();
		shape.setRadius(1.0f);

		for (int i = 0; i < e_count; ++i) {
			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(0.0f, 4.0f + 3.0f * i);

			m_bodies[i] = m_world.createBody(bd);

			m_bodies[i].createFixture(shape, 1.0f);

			m_bodies[i].setLinearVelocity(new Vector2(0.0f, -50.0f));
		}
	}
 
	@Override
	protected void step() {
		// settings->viewCenter.x = m_car->GetPosition().x;
		super.step();

	}

}
