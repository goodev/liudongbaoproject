package com.hellogame;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class CharacterCollisionGame extends Box2DTestGame {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		// Ground body
		{
			BodyDef bd = new BodyDef();

			Body ground = world.createBody(bd);
			EdgeShape shape = new EdgeShape();
			shape.set(new Vector2(-20.0f, 0.0f), new Vector2(20.0f, 0.0f));
			ground.createFixture(shape, 0.0f);
		}
		// Collinear edges with no adjacency information.
		// This shows the problematic case where a box shape can hit
		// an internal vertex.
		{
			BodyDef bd = new BodyDef();
			Body ground = world.createBody(bd);
			EdgeShape shape = new EdgeShape();
			shape.set(new Vector2(-8.0f, 1.0f), new Vector2(-6.0f, 1.0f));
			ground.createFixture(shape, 0.0f);

			shape.set(new Vector2(-6.0f, 1.0f), new Vector2(-4.0f, 1.0f));
			ground.createFixture(shape, 0.0f);

			shape.set(new Vector2(-4.0f, 1.0f), new Vector2(-2.0f, 1.0f));
			ground.createFixture(shape, 0.0f);

		}

		// Chain shape
		{
			BodyDef bd = new BodyDef();
			bd.angle = 0.25f * 3.15149265f;
			Body ground = world.createBody(bd);

			Vector2[] vs = new Vector2[4];
			vs[0] = new Vector2(5.0f, 7.0f);
			vs[1] = new Vector2(6.0f, 8.0f);
			vs[2] = new Vector2(7.0f, 8.0f);
			vs[3] = new Vector2(8.0f, 7.0f);
			ChainShape shape = new ChainShape();
			shape.createChain(vs);
			ground.createFixture(shape, 0.0f);
		}

		// Square tiles. This shows that adjacency shapes may
		// have non-smooth collision. There is no solution
		// to this problem.
		{
			BodyDef bd = new BodyDef();
			Body ground = world.createBody(bd);

			PolygonShape shape = new PolygonShape();
			shape.setAsBox(1.0f, 1.0f, new Vector2(4.0f, 3.0f), 0.0f);
			ground.createFixture(shape, 0.0f);
			shape.setAsBox(1.0f, 1.0f, new Vector2(6.0f, 3.0f), 0.0f);
			ground.createFixture(shape, 0.0f);
			shape.setAsBox(1.0f, 1.0f, new Vector2(8.0f, 3.0f), 0.0f);
			ground.createFixture(shape, 0.0f);
		}

		// Square made from an edge loop. Collision should be smooth.
		{
			BodyDef bd = new BodyDef();
			Body ground = world.createBody(bd);

			Vector2[] vs = new Vector2[4];
			vs[0] = new Vector2(-1.0f, 3.0f);
			vs[1] = new Vector2(1.0f, 3.0f);
			vs[2] = new Vector2(1.0f, 5.0f);
			vs[3] = new Vector2(-1.0f, 5.0f);
			ChainShape shape = new ChainShape();
			shape.createLoop(vs);
			ground.createFixture(shape, 0.0f);
		}

		// Edge loop. Collision should be smooth.
		{
			BodyDef bd = new BodyDef();
			bd.position.set(-10.0f, 4.0f);
			Body ground = world.createBody(bd);

			Vector2[] vs = new Vector2[10];
			vs[0] = new Vector2(0.0f, 0.0f);
			vs[1] = new Vector2(6.0f, 0.0f);
			vs[2] = new Vector2(6.0f, 2.0f);
			vs[3] = new Vector2(4.0f, 1.0f);
			vs[4] = new Vector2(2.0f, 2.0f);
			vs[5] = new Vector2(0.0f, 2.0f);
			vs[6] = new Vector2(-2.0f, 2.0f);
			vs[7] = new Vector2(-4.0f, 3.0f);
			vs[8] = new Vector2(-6.0f, 2.0f);
			vs[9] = new Vector2(-6.0f, 0.0f);
			ChainShape shape = new ChainShape();
			shape.createLoop(vs);
			ground.createFixture(shape, 0.0f);
		}

		// Square character 1
		{
			BodyDef bd = new BodyDef();
			bd.position.set(-3.0f, 8.0f);
			bd.type = BodyType.DynamicBody;
			bd.fixedRotation = true;
			bd.allowSleep = false;

			Body body = world.createBody(bd);

			PolygonShape shape = new PolygonShape();
			shape.setAsBox(0.5f, 0.5f);

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 20.0f;
			body.createFixture(fd);
		}

		// Square character 2
		{
			BodyDef bd = new BodyDef();
			bd.position.set(-5.0f, 5.0f);
			bd.type = BodyType.DynamicBody;
			bd.fixedRotation = true;
			bd.allowSleep = false;

			Body body = world.createBody(bd);

			PolygonShape shape = new PolygonShape();
			shape.setAsBox(0.25f, 0.25f);

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 20.0f;
			body.createFixture(fd);
		}

		// Hexagon character
		{
			BodyDef bd = new BodyDef();
			bd.position.set(-5.0f, 8.0f);
			bd.type = BodyType.DynamicBody;
			bd.fixedRotation = true;
			bd.allowSleep = false;

			Body body = world.createBody(bd);

			float angle = 0.0f;
			float delta = 3.14159265f / 3.0f;
			Vector2 vertices[] = new Vector2[6];
			for (int i = 0; i < 6; ++i) {
				vertices[i] = new Vector2(0.5f * MathUtils.cos(angle),
						0.5f * MathUtils.sin(angle));
				angle += delta;
			}

			PolygonShape shape = new PolygonShape();
			shape.set(vertices);

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 20.0f;
			body.createFixture(fd);
		}

		// Circle character
		{
			BodyDef bd = new BodyDef();
			bd.position.set(3.0f, 5.0f);
			bd.type = BodyType.DynamicBody;
			bd.fixedRotation = true;
			bd.allowSleep = false;

			Body body = world.createBody(bd);

			CircleShape shape = new CircleShape();
			shape.setRadius(0.5f);

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 20.0f;
			body.createFixture(fd);
		}

		// Circle character
		{
			BodyDef bd = new BodyDef();
			bd.position.set(-7.0f, 6.0f);
			bd.type = BodyType.DynamicBody;
			bd.allowSleep = false;

			Body m_character = world.createBody(bd);

			CircleShape shape = new CircleShape();
			shape.setRadius(0.25f);

			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 20.0f;
			fd.friction = 1.0f;
			m_character.createFixture(fd);
		}
	}

}
