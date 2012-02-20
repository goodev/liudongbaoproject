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

 
public class VerticalStackGame extends Box2DTestGame {
	final int e_columnCount = 5, e_rowCount = 16;
	Body m_bullet;
	Body[] m_bodies = new Body[e_rowCount * e_columnCount];
	int[] m_indices = new int[e_rowCount * e_columnCount];

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
			shape.set(new Vector2(20.0f, 0.0f), new Vector2(20.0f, 20.0f));
			ground.createFixture(shape, 0.0f);

		}
		float[] xs = { 0.0f, -10.0f, -5.0f, 5.0f, 10.0f };

		for (int j = 0; j < e_columnCount; ++j) {
			PolygonShape shape = new PolygonShape();
			shape.setAsBox(0.5f, 0.5f);

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 1.0f;
			fd.friction = 0.3f;

			for (int i = 0; i < e_rowCount; ++i) {
				BodyDef bd = new BodyDef();
				bd.type = BodyType.DynamicBody;

				int n = j * e_rowCount + i;
				m_indices[n] = n;
				float x = 0.0f;
				bd.position.set(xs[j] + x, 0.752f + 1.54f * i);
				Body body = m_world.createBody(bd);
				body.setUserData(Integer.valueOf(m_indices[n]));
				m_bodies[n] = body;

				body.createFixture(fd);
			}
		}

		m_bullet = null;
	}

	@Override
	public boolean keyTyped(char character) {
		switch (character) {
		case ',':
			if (m_bullet != null) {
				m_world.destroyBody(m_bullet);
				m_bullet = null;
			}

			{
				CircleShape shape = new CircleShape();
				shape.setRadius(0.25f);

				FixtureDef fd = new FixtureDef();
				fd.shape = shape;
				fd.density = 20.0f;
				fd.restitution = 0.05f;

				BodyDef bd = new BodyDef();
				bd.type = BodyType.DynamicBody;
				bd.bullet = true;
				bd.position.set(-31.0f, 5.0f);

				m_bullet = m_world.createBody(bd);
				m_bullet.createFixture(fd);

				m_bullet.setLinearVelocity(new Vector2(400.0f, 0.0f));
			}
		}
		return super.keyTyped(character);
	}

	@Override
	protected void step() {
		// settings->viewCenter.x = m_car->GetPosition().x;
		super.step();

	}

}
