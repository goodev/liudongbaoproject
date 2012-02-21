package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;

public class WebGame extends Box2DTestGame {
	Body[] m_bodies = new Body[4];
	Joint[] m_joints = new Joint[8];

	void JointDestroyed(Joint joint) {
		for (int i = 0; i < 8; ++i) {
			if (m_joints[i] == joint) {
				m_joints[i] = null;
				break;
			}
		}
	}

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
			shape.setAsBox(0.5f, 0.5f);

			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;

			bd.position.set(-5.0f, 5.0f);
			m_bodies[0] = m_world.createBody(bd);
			m_bodies[0].createFixture(shape, 5.0f);

			bd.position.set(5.0f, 5.0f);
			m_bodies[1] = m_world.createBody(bd);
			m_bodies[1].createFixture(shape, 5.0f);

			bd.position.set(5.0f, 15.0f);
			m_bodies[2] = m_world.createBody(bd);
			m_bodies[2].createFixture(shape, 5.0f);

			bd.position.set(-5.0f, 15.0f);
			m_bodies[3] = m_world.createBody(bd);
			m_bodies[3].createFixture(shape, 5.0f);

			DistanceJointDef jd = new DistanceJointDef();
			Vector2 p1, p2, d;

			jd.frequencyHz = 2.0f;
			jd.dampingRatio = 0.0f;

			jd.bodyA = ground;
			jd.bodyB = m_bodies[0];
			jd.localAnchorA.set(-10.0f, 0.0f);
			jd.localAnchorB.set(-0.5f, -0.5f);
			p1 = jd.bodyA.getWorldPoint(jd.localAnchorA);
			p2 = jd.bodyB.getWorldPoint(jd.localAnchorB);
			d = p2.sub(p1);
			jd.length = d.len();
			m_joints[0] = m_world.createJoint(jd);

			jd.bodyA = ground;
			jd.bodyB = m_bodies[1];
			jd.localAnchorA.set(10.0f, 0.0f);
			jd.localAnchorB.set(0.5f, -0.5f);
			p1 = jd.bodyA.getWorldPoint(jd.localAnchorA);
			p2 = jd.bodyB.getWorldPoint(jd.localAnchorB);
			d = p2.sub(p1);
			jd.length = d.len();
			m_joints[1] = m_world.createJoint(jd);

			jd.bodyA = ground;
			jd.bodyB = m_bodies[2];
			jd.localAnchorA.set(10.0f, 20.0f);
			jd.localAnchorB.set(0.5f, 0.5f);
			p1 = jd.bodyA.getWorldPoint(jd.localAnchorA);
			p2 = jd.bodyB.getWorldPoint(jd.localAnchorB);
			d = p2.sub(p1);
			jd.length = d.len();
			m_joints[2] = m_world.createJoint(jd);

			jd.bodyA = ground;
			jd.bodyB = m_bodies[3];
			jd.localAnchorA.set(-10.0f, 20.0f);
			jd.localAnchorB.set(-0.5f, 0.5f);
			p1 = jd.bodyA.getWorldPoint(jd.localAnchorA);
			p2 = jd.bodyB.getWorldPoint(jd.localAnchorB);
			d = p2.sub(p1);
			jd.length = d.len();
			m_joints[3] = m_world.createJoint(jd);

			jd.bodyA = m_bodies[0];
			jd.bodyB = m_bodies[1];
			jd.localAnchorA.set(0.5f, 0.0f);
			jd.localAnchorB.set(-0.5f, 0.0f);
			;
			p1 = jd.bodyA.getWorldPoint(jd.localAnchorA);
			p2 = jd.bodyB.getWorldPoint(jd.localAnchorB);
			d = p2.sub(p1);
			jd.length = d.len();
			m_joints[4] = m_world.createJoint(jd);

			jd.bodyA = m_bodies[1];
			jd.bodyB = m_bodies[2];
			jd.localAnchorA.set(0.0f, 0.5f);
			jd.localAnchorB.set(0.0f, -0.5f);
			p1 = jd.bodyA.getWorldPoint(jd.localAnchorA);
			p2 = jd.bodyB.getWorldPoint(jd.localAnchorB);
			d = p2.sub(p1);
			jd.length = d.len();
			m_joints[5] = m_world.createJoint(jd);

			jd.bodyA = m_bodies[2];
			jd.bodyB = m_bodies[3];
			jd.localAnchorA.set(-0.5f, 0.0f);
			jd.localAnchorB.set(0.5f, 0.0f);
			p1 = jd.bodyA.getWorldPoint(jd.localAnchorA);
			p2 = jd.bodyB.getWorldPoint(jd.localAnchorB);
			d = p2.sub(p1);
			jd.length = d.len();
			m_joints[6] = m_world.createJoint(jd);

			jd.bodyA = m_bodies[3];
			jd.bodyB = m_bodies[0];
			jd.localAnchorA.set(0.0f, -0.5f);
			jd.localAnchorB.set(0.0f, 0.5f);
			p1 = jd.bodyA.getWorldPoint(jd.localAnchorA);
			p2 = jd.bodyB.getWorldPoint(jd.localAnchorB);
			d = p2.sub(p1);
			jd.length = d.len();
			m_joints[7] = m_world.createJoint(jd);
		}
	}

	@Override
	public boolean keyTyped(char character) {
		switch (character) {
		case 'b':
			for (int i = 0; i < 4; ++i) {
				if (m_bodies[i] != null) {
					m_world.destroyBody(m_bodies[i]);
					m_bodies[i] = null;
					break;
				}
			}
			break;

		case 'j':
			for (int i = 0; i < 8; ++i) {
				if (m_joints[i] != null) {
					m_world.destroyJoint(m_joints[i]);
					m_joints[i] = null;
					break;
				}
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
