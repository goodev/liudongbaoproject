/**
 * 
 */
package com.hellogame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author liudongbao
 * 
 */
public class FirstActor extends Actor {

	Texture texture1;
	Texture texture2;
	Animation animation;
	TextureRegion[] walksFrame;
	float stateTime;

	/**
	 * 
	 */
	public FirstActor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public FirstActor(String name) {
		super(name);
		texture1 = new Texture(Gdx.files.internal("actor1.jpg"));
        texture2 = new Texture(Gdx.files.internal("actor2.jpg"));
        this.height = texture1.getHeight();
        this.width = texture1.getWidth();
        TextureRegion region1;
        TextureRegion region2;
        region1 = new TextureRegion(texture1);
        region2 = new TextureRegion(texture2);
        walksFrame = new TextureRegion[30];
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {
                walksFrame[i] = region1;
            } else {
                walksFrame[i] = region2;
            }
        }
        animation = new Animation(0.25f, walksFrame);
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
		stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, this.x, this.y);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.scenes.scene2d.Actor#touchDown(float, float, int)
	 */
	@Override
	public boolean touchDown(float x, float y, int pointer) {
		
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
		Gdx.app.log("INFO", x + " " + this.width);
        if (x > 0 && y > 0 && this.height > y && this.width > x) {
            return this;
        } else {
            return null;
        }
	}

}
