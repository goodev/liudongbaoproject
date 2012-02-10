package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class EdgeTestGame extends Box2DTestGame {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		{
			BodyDef bd = new BodyDef();
			Body ground = world.createBody(bd);
			Vector2 v1 = new Vector2(-10.0f, 0.0f);
			Vector2 v2 = new Vector2(-7.0f, -2.0f);
			Vector2 v3 = new Vector2(-4.0f, 0.0f);
			Vector2 v4 = new Vector2(0.0f, 0.0f);
			Vector2 v5 = new Vector2(4.0f, 0.0f);
			Vector2 v6 = new Vector2(7.0f, 2.0f);
			Vector2 v7 = new Vector2(10.0f, 0.0f);

			EdgeShape shape = new EdgeShape();

			shape.set(v1, v2);
			ground.createFixture(shape, 0.0f);

			shape.set(v2, v3);

			ground.createFixture(shape, 0.0f);

			shape.set(v3, v4);

			ground.createFixture(shape, 0.0f);

			shape.set(v4, v5);
			ground.createFixture(shape, 0.0f);

			shape.set(v5, v6);
			ground.createFixture(shape, 0.0f);

			shape.set(v6, v7);
			ground.createFixture(shape, 0.0f);
		}

		{
			BodyDef bd = new BodyDef();
			bd.position.set(-5.0f, 6.0f);
			bd.type = BodyType.DynamicBody;
			bd.allowSleep = false;

			Body body = world.createBody(bd);

			CircleShape shape = new CircleShape();
			shape.setRadius(0.5f);

			body.createFixture(shape, 1.0f);
		}

		{

			BodyDef bd = new BodyDef();
			bd.position.set(1.0f, 6.0f);
			bd.type = BodyType.DynamicBody;
			bd.allowSleep = false;

			Body body = world.createBody(bd);

			PolygonShape shape = new PolygonShape();
			shape.setAsBox(0.5f, 0.5f);

			body.createFixture(shape, 1.0f);
		}
	}

}
