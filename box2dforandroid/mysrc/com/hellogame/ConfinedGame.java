package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class ConfinedGame extends Box2DTestGame {
	final int e_columnCount = 0;
	final int e_rowCount = 0;

	@Override
	public void create() {
		super.create();

		{
			BodyDef bd = new BodyDef();
			Body ground = m_world.createBody(bd);

			EdgeShape shape = new EdgeShape();

			// Floor
			shape.set(new Vector2(-10.0f, 0.0f), new Vector2(10.0f, 0.0f));
			ground.createFixture(shape, 0.0f);

			// Left wall
			shape.set(new Vector2(-10.0f, 0.0f), new Vector2(-10.0f, 20.0f));
			ground.createFixture(shape, 0.0f);

			// Right wall
			shape.set(new Vector2(10.0f, 0.0f), new Vector2(10.0f, 20.0f));
			ground.createFixture(shape, 0.0f);
			// Roof
			shape.set(new Vector2(-10.0f, 20.0f), new Vector2(10.0f, 20.0f));
			ground.createFixture(shape, 0.0f);
		}
		float radius = 0.5f;
		CircleShape shape = new CircleShape();
		shape.setPosition(new Vector2(0.0f, 0.0f));
		shape.setRadius(radius);

		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		fd.density = 1.0f;
		fd.friction = 0.1f;

		for (int j = 0; j < e_columnCount; ++j) {
			for (int i = 0; i < e_rowCount; ++i) {
				BodyDef bd = new BodyDef();
				bd.type = BodyType.DynamicBody;
				bd.position.set(new Vector2(-10.0f
						+ (2.1f * j + 1.0f + 0.01f * i) * radius,
						(2.0f * i + 1.0f) * radius));
				Body body = m_world.createBody(bd);

				body.createFixture(fd);
			}
		}

		m_world.setGravity(new Vector2(0.0f, 0.0f));
	}

	void CreateCircle() {
		float radius = 2.0f;
		CircleShape shape = new CircleShape();
		shape.setPosition(new Vector2(0.0f, 0.0f));
		shape.setRadius(radius);

		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		fd.density = 1.0f;
		fd.friction = 0.0f;

		Vector2 p = new Vector2(RandomFloat(), 3.0f + RandomFloat());
		BodyDef bd = new BodyDef();
		bd.type = BodyType.DynamicBody;
		bd.position.set(p);
		// bd.allowSleep = false;
		Body body = m_world.createBody(bd);

		body.createFixture(fd);
	}

	@Override
	public boolean keyTyped(char character) {
		switch (character) {
		case 'c':
			CreateCircle();
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
