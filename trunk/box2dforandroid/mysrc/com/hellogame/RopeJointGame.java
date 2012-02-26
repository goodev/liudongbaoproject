package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.badlogic.gdx.physics.box2d.joints.RopeJointDef;
/// This test shows how a rope joint can be used to stabilize a chain of
/// bodies with a heavy payload. Notice that the rope joint just prevents
/// excessive stretching and has no other effect.
/// By disabling the rope joint you can see that the Box2D solver has trouble
/// supporting heavy bodies with light bodies. Try playing around with the
/// densities, time step, and iterations to see how they affect stability.
/// This test also shows how to use contact filtering. Filtering is configured
/// so that the payload does not collide with the chain.

public class RopeJointGame extends Box2DTestGame {
	RopeJointDef m_ropeDef = new RopeJointDef();
	Joint m_rope;

	@Override
	public void create() {
		super.create();

		Body ground = null;
		{
			BodyDef bd = new BodyDef();
			ground = m_world.createBody(bd);
			EdgeShape shape = new EdgeShape();
			shape.set(new Vector2(-40.0f, 0.0f), new Vector2(40.0f, 0.0f));
			ground.createFixture(shape, 0.0f);

		}
		{
			PolygonShape shape = new PolygonShape();
			shape.setAsBox(0.5f, 0.125f);

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 20.0f;
			fd.friction = 0.2f;
			fd.filter.categoryBits = 0x0001;
			fd.filter.maskBits = (short) 0xFFFF & ~0x0002;

			RevoluteJointDef jd = new RevoluteJointDef();
			jd.collideConnected = false;

			final int N = 10;
			final float y = 15.0f;
			m_ropeDef.localAnchorA.set(0.0f, y);

			Body prevBody = ground;
			for (int i = 0; i < N; ++i) {
				BodyDef bd = new BodyDef();
				bd.type = BodyType.DynamicBody;
				bd.position.set(0.5f + 1.0f * i, y);
				if (i == N - 1) {
					shape.setAsBox(1.5f, 1.5f);
					fd.density = 100.0f;
					fd.filter.categoryBits = 0x0002;
					bd.position.set(1.0f * i, y);
					bd.angularDamping = 0.4f;
				}

				Body body = m_world.createBody(bd);

				body.createFixture(fd);

				Vector2 anchor = new Vector2(i, y);
				jd.initialize(prevBody, body, anchor);
				m_world.createJoint(jd);

				prevBody = body;
			}

			m_ropeDef.localAnchorB.set(0.0f, 0.0f);

			float extraLength = 0.01f;
			m_ropeDef.maxLength = N - 1.0f + extraLength;
			m_ropeDef.bodyB = prevBody;
		}

		{
			m_ropeDef.bodyA = ground;
			m_rope = m_world.createJoint(m_ropeDef);
		}

	}

	@Override
	public boolean keyTyped(char character) {
		switch (character) {
		case 'j':
			if (m_rope != null) {
				m_world.destroyJoint(m_rope);
				m_rope = null;
			} else {
				m_rope = m_world.createJoint(m_ropeDef);
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
