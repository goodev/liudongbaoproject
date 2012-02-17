package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class VaryingRestitutionGame extends Box2DTestGame {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		// Ground
		BodyDef groundBodyDef = new BodyDef();
		groundBody = m_world.createBody(groundBodyDef);
		EdgeShape edgeShape = new EdgeShape();
		edgeShape.set(new Vector2(-40.0f, 0.0f), new Vector2(40.0f, 0.0f));
		groundBody.createFixture(edgeShape, 0.0f);

		{
			CircleShape shape = new CircleShape();
			shape.setRadius(1.0f);
			FixtureDef fd = new FixtureDef();
			fd.shape = shape;
			fd.density = 1.0f;

			float[] restitution = { 0.0f, 0.1f, 0.3f, 0.5f, 0.75f, 0.9f, 1.0f };
			for (int i = 0; i < 7; ++i) {
				BodyDef bd = new BodyDef();
				bd.type = BodyType.DynamicBody;
				bd.position.set(-10.0f + 3.0f * i, 20.0f);
				Body body = m_world.createBody(bd);
				fd.restitution = restitution[i];
				body.createFixture(fd);
			}
		}
	}

}
