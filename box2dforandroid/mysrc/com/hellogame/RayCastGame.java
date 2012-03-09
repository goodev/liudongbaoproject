package com.hellogame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.RayCastCallback;

//This callback finds the closest hit. Polygon 0 is filtered.
class RayCastClosestCallback implements RayCastCallback {
	boolean m_hit = false;
	Vector2 m_point = new Vector2();
	Vector2 m_normal = new Vector2();

	@Override
	public float reportRayFixture(Fixture fixture, Vector2 point,
			Vector2 normal, float fraction) {
		Body body = fixture.getBody();
		Object userData = body.getUserData();
		if (userData != null) {
			int index = ((Integer) userData).intValue();
			if (index == 0) {
				// filter
				return -1.0f;
			}
		}
		m_hit = true;
		m_point = point;
		m_normal = normal;
		return fraction;
	}

}

// This callback finds any hit. Polygon 0 is filtered.
class RayCastAnyCallback implements RayCastCallback {
	boolean m_hit = false;
	Vector2 m_point = new Vector2();
	Vector2 m_normal = new Vector2();

	@Override
	public float reportRayFixture(Fixture fixture, Vector2 point,
			Vector2 normal, float fraction) {
		Body body = fixture.getBody();
		Object userData = body.getUserData();
		if (userData != null) {
			int index = ((Integer) userData).intValue();
			if (index == 0) {
				// filter
				return 0.0f;
			}
		}
		m_hit = true;
		m_point = point;
		m_normal = normal;
		return fraction;
	}

}

// This ray cast collects multiple hits along the ray. Polygon 0 is filtered.
class RayCastMultipleCallback implements RayCastCallback {
	final int e_maxCount = 3;
	Vector2[] m_points = new Vector2[e_maxCount];
	Vector2[] m_normals = new Vector2[e_maxCount];
	int m_count = 0;

	@Override
	public float reportRayFixture(Fixture fixture, Vector2 point,
			Vector2 normal, float fraction) {
		Body body = fixture.getBody();
		Object userData = body.getUserData();
		if (userData != null) {
			int index = ((Integer) userData).intValue();
			if (index == 0) {
				// filter
				return -1.0f;
			}
		}
		m_points[m_count] = point;
		m_normals[m_count] = normal;
		++m_count;

		if (m_count == e_maxCount) {
			return 0.0f;
		}

		return 1.0f;
	}

}

// This test demonstrates how to use the world ray-cast feature.
// NOTE: we are intentionally filtering one of the polygons, therefore
// the ray will always miss one type of polygon.
public class RayCastGame extends Box2DTestGame {
	final int e_maxBodies = 256;

	enum Mode {
		e_closest, e_any, e_multiple
	};

	int m_bodyIndex;
	Body[] m_bodies = new Body[e_maxBodies];
	int[] m_userData = new int[e_maxBodies];
	PolygonShape[] m_polygons = new PolygonShape[4];
	CircleShape m_circle = new CircleShape();

	float m_angle = 0.0f;

	Mode m_mode;

	@Override
	public void create() {
		super.create();
		// Ground body
		Body ground = null;
		{
			BodyDef bd = new BodyDef();
			ground = m_world.createBody(bd);
			EdgeShape shape = new EdgeShape();
			shape.set(new Vector2(-40.0f, 0.0f), new Vector2(40.0f, 0.0f));
			ground.createFixture(shape, 0.0f);

		}
		{
			Vector2[] vertices = new Vector2[3];
			vertices[0] = new Vector2(-0.5f, 0.0f);
			vertices[1] = new Vector2(0.5f, 0.0f);
			vertices[2] = new Vector2(0.0f, 1.5f);
			m_polygons[0].set(vertices);
		}
		{
			Vector2[] vertices = new Vector2[3];
			vertices[0] = new Vector2(-0.1f, 0.0f);
			vertices[1] = new Vector2(0.1f, 0.0f);
			vertices[2] = new Vector2(0.0f, 1.5f);
			m_polygons[1].set(vertices);
		}
		{
			float w = 1.0f;
			float b = w / (2.0f + (float) Math.sqrt(2.0));
			float s = (float) Math.sqrt(2.0f) * b;

			Vector2[] vertices = new Vector2[8];
			vertices[0] = new Vector2(0.5f * s, 0.0f);
			vertices[1] = new Vector2(0.5f * w, b);
			vertices[2] = new Vector2(0.5f * w, b + s);
			vertices[3] = new Vector2(0.5f * s, w);
			vertices[4] = new Vector2(-0.5f * s, w);
			vertices[5] = new Vector2(-0.5f * w, b + s);
			vertices[6] = new Vector2(-0.5f * w, b);
			vertices[7] = new Vector2(-0.5f * s, 0.0f);

			m_polygons[2].set(vertices);
		}

		{
			m_polygons[3].setAsBox(0.5f, 0.5f);
		}

		{
			m_circle.setRadius(0.5f);
		}
		m_bodyIndex = 0;
		m_angle = 0.0f;

		m_mode = Mode.e_closest;
	}

	void Create(int index) {
		if (m_bodies[m_bodyIndex] != null) {
			m_world.destroyBody(m_bodies[m_bodyIndex]);
			m_bodies[m_bodyIndex] = null;
		}

		BodyDef bd = new BodyDef();

		float x = RandomFloat() * 10;
		float y = RandomFloat() * 20;
		bd.position.set(x, y);
		bd.angle = (float) (RandomFloat() * 3.14);

		m_userData[m_bodyIndex] = index;
		if (index == 4) {
			bd.angularDamping = 0.02f;
		}

		m_bodies[m_bodyIndex] = m_world.createBody(bd);

		m_bodies[m_bodyIndex].setUserData(new Integer(m_userData[m_bodyIndex]));
		if (index < 4) {
			FixtureDef fd = new FixtureDef();
			fd.shape = m_polygons[index];
			fd.friction = 0.3f;
			m_bodies[m_bodyIndex].createFixture(fd);
		} else {
			FixtureDef fd = new FixtureDef();
			fd.shape = m_circle;
			fd.friction = 0.3f;

			m_bodies[m_bodyIndex].createFixture(fd);
		}

		m_bodyIndex = (m_bodyIndex + 1) % e_maxBodies;
	}

	void DestroyBody() {
		for (int i = 0; i < e_maxBodies; ++i) {
			if (m_bodies[i] != null) {
				m_world.destroyBody(m_bodies[i]);
				m_bodies[i] = null;
				return;
			}
		}
	}

	@Override
	public boolean keyTyped(char character) {
		switch (character) {
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
			Create(character - '1');
			break;

		case 'd':
			DestroyBody();
			break;

		case 'm':
			if (m_mode == Mode.e_closest) {
				m_mode = Mode.e_any;
			} else if (m_mode == Mode.e_any) {
				m_mode = Mode.e_multiple;
			} else if (m_mode == Mode.e_multiple) {
				m_mode = Mode.e_closest;
			}
		}
		return super.keyTyped(character);
	}

	@Override
	protected void step() {
		boolean advanceRay = true;

		super.step() ;
 

		float  L = 11.0f;
		Vector2 point1 = new Vector2(0.0f, 10.0f);
		Vector2 d = new Vector2((float)(L * Math.cos(m_angle)), (float)(L * Math.sin(m_angle)));
		Vector2 point2 = point1.add(d);

		if (m_mode == Mode.e_closest)
		{
			RayCastClosestCallback callback =new RayCastClosestCallback();
			m_world.rayCast( callback, point1, point2);

			if (callback.m_hit)
			{
				/*
				m_debugDraw.drawPoint(callback.m_point, 5.0f, new Color(0.4f, 0.9f, 0.4f));
				m_debugDraw.drawSegment(point1, callback.m_point,new Color(0.8f, 0.8f, 0.8f));
				b2Vec2 head = callback.m_point + 0.5f * callback.m_normal;
				m_debugDraw.DrawSegment(callback.m_point, head, b2Color(0.9f, 0.9f, 0.4f));*/
			}
			else
			{
				//m_debugDraw.DrawSegment(point1, point2, b2Color(0.8f, 0.8f, 0.8f));
			}
		}
		else if (m_mode == Mode.e_any)
		{
			RayCastAnyCallback callback =new RayCastAnyCallback();
			m_world.rayCast(callback, point1, point2);

			if (callback.m_hit)
			{/*
				m_debugDraw.DrawPoint(callback.m_point, 5.0f, b2Color(0.4f, 0.9f, 0.4f));
				m_debugDraw.DrawSegment(point1, callback.m_point, b2Color(0.8f, 0.8f, 0.8f));
				b2Vec2 head = callback.m_point + 0.5f * callback.m_normal;
				m_debugDraw.DrawSegment(callback.m_point, head, b2Color(0.9f, 0.9f, 0.4f));*/
			}
			else
			{
				//m_debugDraw.DrawSegment(point1, point2, b2Color(0.8f, 0.8f, 0.8f));
			}
		}
		else if (m_mode == Mode.e_multiple)
		{
			RayCastMultipleCallback callback =new RayCastMultipleCallback();
			m_world.rayCast( callback, point1, point2);
			//m_debugDraw.DrawSegment(point1, point2, b2Color(0.8f, 0.8f, 0.8f));

			for (int  i = 0; i < callback.m_count; ++i)
			{
				Vector2 p = callback.m_points[i];
				Vector2 n = callback.m_normals[i];
				/*m_debugDraw.DrawPoint(p, 5.0f, b2Color(0.4f, 0.9f, 0.4f));
				m_debugDraw.DrawSegment(point1, p, b2Color(0.8f, 0.8f, 0.8f));
				b2Vec2 head = p + 0.5f * n;
				m_debugDraw.DrawSegment(p, head, b2Color(0.9f, 0.9f, 0.4f));
				*/
			}
		}

		if (advanceRay)
		{
			m_angle += 0.25f * b2_pi / 180.0f;
		}

	}
}
