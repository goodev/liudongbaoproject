/**
 * 
 */
package com.hellogame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author liudongbao
 * 
 */
public class NarrowButton extends Actor {

	Texture texture;

	/**
	 * 
	 */
	public NarrowButton() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public NarrowButton(String name) {
		super(name);
		texture = new Texture(Gdx.files.internal("narrow.png"));
		this.height = texture.getHeight();
		this.width = texture.getWidth();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.badlogic.gdx.scenes.scene2d.Actor#draw(com.badlogic.gdx.graphics.
	 * g2d.SpriteBatch, float)
	 */
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.draw(texture, this.x, this.y);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.scenes.scene2d.Actor#touchDown(float, float, int)
	 */
	@Override
	public boolean touchDown(float x, float y, int pointer) {
		Actor actor = this.parent.findActor("renwu");
		actor.x += 10;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.scenes.scene2d.Actor#touchUp(float, float, int)
	 */
	@Override
	public void touchUp(float x, float y, int pointer) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.scenes.scene2d.Actor#touchDragged(float, float,
	 * int)
	 */
	@Override
	public void touchDragged(float x, float y, int pointer) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.scenes.scene2d.Actor#hit(float, float)
	 */
	@Override
	public Actor hit(float x, float y) {
		if (x > 0 && y > 0 && this.height > y && this.width > x) {
			return this;
		} else {
			return null;
		}
	}

}
