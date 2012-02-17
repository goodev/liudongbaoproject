package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.WeldJointDef;

public class CantileverGame extends Box2DTestGame {

	Body middle;
	private int e_count = 8;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		// Ground
		BodyDef groundBodyDef = new BodyDef();
		Body ground = m_world.createBody(groundBodyDef);
		EdgeShape edgeShape = new EdgeShape();
		edgeShape.set(new Vector2(-40.0f, 0.0f), new Vector2(40.0f, 0.0f));
		ground.createFixture(edgeShape, 0.0f);
		createFirstWeldJoint(ground);
		createSecondWeldJoint(ground);
		createFirstWeldJointNotJoinGround(ground);
		createSecondWeldJointNotJoinGround(ground);
		createVerticesType();
		createCircleType();
	}

	private void createCircleType() {
		for (int i = 0; i < 2; ++i) {
			CircleShape shape = new CircleShape();
			shape.setRadius(0.5f);
			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 1.0f;

			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(-6.0f + 6.0f * i, 10.0f);
			Body body = m_world.createBody(bd);
			body.createFixture(fd);
		}
	}

	private void createVerticesType() {
		for (int i = 0; i < 2; ++i) {
			Vector2[] vertices = new Vector2[3];
			vertices[0] = new Vector2(-0.5f, 0.0f);
			vertices[1] = new Vector2(0.5f, 0.0f);
			vertices[2] = new Vector2(0.0f, 1.5f);
			PolygonShape shape = new PolygonShape();
			shape.set(vertices);
			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 1.0f;

			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(-8.0f + 8.0f * i, 12.0f);
			Body body = m_world.createBody(bd);
			body.createFixture(fd);
		}
	}

	private void createSecondWeldJointNotJoinGround(Body ground) {
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(0.5f, 0.125f);
		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		fd.density = 20.0f;
		WeldJointDef jd = new WeldJointDef();
		Body prevBody = ground;
		for (int i = 0; i < e_count; ++i) {
			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(5.0f + 1.0f * i, 10.0f);
			Body body = m_world.createBody(bd);
			body.createFixture(fd);
			if (i > 0) {
				Vector2 anchor = new Vector2(5.0f + 1.0f * i, 10.0f);
				jd.initialize(prevBody, body, anchor);
				m_world.createJoint(jd);
			}
			prevBody = body;
		}
	}

	private void createFirstWeldJointNotJoinGround(Body ground) {
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(0.5f, 0.125f);
		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		fd.density = 20.0f;
		WeldJointDef jd = new WeldJointDef();
		Body prevBody = ground;
		for (int i = 0; i < e_count; ++i) {
			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(-4.5f + 1.0f * i, 5.0f);
			Body body = m_world.createBody(bd);
			body.createFixture(fd);
			if (i > 0) {
				Vector2 anchor = new Vector2(-5.0f + 1.0f * i, 5.0f);
				jd.initialize(prevBody, body, anchor);
				m_world.createJoint(jd);
			}
			prevBody = body;
		}

	}

	private void createSecondWeldJoint(Body ground) {
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(1.0f, 0.125f);
		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		fd.density = 20.0f;
		WeldJointDef jd = new WeldJointDef();
		Body prevBody = ground;
		for (int i = 0; i < 3; ++i) {
			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(-14.0f + 2.0f * i, 15.0f);
			Body body = m_world.createBody(bd);
			body.createFixture(fd);
			Vector2 anchor = new Vector2(-15.0f + 2.0f * i, 15.0f);
			jd.initialize(prevBody, body, anchor);
			m_world.createJoint(jd);
			prevBody = body;
		}
	}

	private void createFirstWeldJoint(Body ground) {
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(0.5f, 0.125f);
		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		fd.density = 20.0f;
		WeldJointDef jd = new WeldJointDef();
		Body prevBody = ground;
		for (int i = 0; i < e_count; ++i) {
			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(-14.5f + 1.0f * i, 5.0f);
			Body body = m_world.createBody(bd);
			body.createFixture(fd);
			Vector2 anchor = new Vector2(-15.0f + 1.0f * i, 5.0f);
			jd.initialize(prevBody, body, anchor);
			m_world.createJoint(jd);
			prevBody = body;
		}
	}

}
