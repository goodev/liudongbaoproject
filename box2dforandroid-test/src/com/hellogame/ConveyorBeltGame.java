package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.box2dforandroid.Body;
import com.box2dforandroid.BodyDef;
import com.box2dforandroid.BodyDef.BodyType;
import com.box2dforandroid.Contact;
import com.box2dforandroid.EdgeShape;
import com.box2dforandroid.Fixture;
import com.box2dforandroid.FixtureDef;
import com.box2dforandroid.Manifold;
import com.box2dforandroid.PolygonShape;

public class ConveyorBeltGame extends Box2DTestGame {

	private Fixture platformFixture;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		// Ground
		BodyDef groundBodyDef = new BodyDef();
		Body groundBody = world.createBody(groundBodyDef);
		EdgeShape edgeShape = new EdgeShape();
		edgeShape.set(new Vector2(-20.0f, 0.0f), new Vector2(20.0f, 0.0f));
		groundBody.createFixture(edgeShape, 0.0f);
		// Platform
		BodyDef platformBodyDef = new BodyDef();
		platformBodyDef.position.set(-5.0f, 5.0f);
		Body platformBody = world.createBody(platformBodyDef);

		PolygonShape polygonShape = new PolygonShape();
		polygonShape.setAsBox(10.0f, 0.5f);

		FixtureDef platformFixtureDef = new FixtureDef();
		platformFixtureDef.shape = polygonShape;
		platformFixtureDef.friction = 0.8f;
		platformFixture = platformBody.createFixture(platformFixtureDef);

		// Boxes
		for (int i = 0; i < 5; ++i) {
			BodyDef bd = new BodyDef();
			bd.type = BodyType.DynamicBody;
			bd.position.set(-10.0f + 2.0f * i, 7.0f);
			Body body = world.createBody(bd);
			PolygonShape shape = new PolygonShape();
			shape.setAsBox(0.5f, 0.5f);
			body.createFixture(shape, 20.0f);
		}
	}
	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		super.preSolve(contact, oldManifold);
		Fixture fixtureA = contact.getFixtureA();
		Fixture fixtureB =  contact.getFixtureB();

		if (fixtureA == this.platformFixture)
		{
		//contact.setTangentSpeed(5.0f);
		}

		if (fixtureB == this.platformFixture)
		{
			//contact.setTangentSpeed(-5.0f);
		}
	}
}
