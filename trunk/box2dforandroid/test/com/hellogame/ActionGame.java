package com.hellogame;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.FadeIn;
import com.badlogic.gdx.scenes.scene2d.actions.FadeOut;
import com.badlogic.gdx.scenes.scene2d.actions.MoveBy;
import com.badlogic.gdx.scenes.scene2d.actions.MoveTo;
import com.badlogic.gdx.scenes.scene2d.actions.Parallel;
import com.badlogic.gdx.scenes.scene2d.actions.Repeat;
import com.badlogic.gdx.scenes.scene2d.actions.RotateTo;
import com.badlogic.gdx.scenes.scene2d.actions.Sequence;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

 
public class ActionGame implements ApplicationListener {
 
    private Stage stage; 
    private Texture texture;
 
    @Override
    public void create() { 
        stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 
                true); 
        texture = new Texture(Gdx.files.internal("star.png")); 
        texture.setFilter(TextureFilter.Linear, TextureFilter.Linear); 
        float duration = 4f; 
        int maxwidth = Gdx.graphics.getWidth() - texture.getWidth(); 
        int maxheight = Gdx.graphics.getHeight() - texture.getHeight();
 
        for (int i = 0; i < 20; i++) { 
            Image image = new Image( texture); 
            image.x = MathUtils.random(0, maxwidth); 
            image.y = MathUtils.random(0, Gdx.graphics.getHeight()); //随机出现 
            Action moveAction = Sequence.$(MoveTo.$(MathUtils.random(0, 
                    maxwidth), MathUtils.random(0, maxheight), duration / 2), 
                    MoveBy.$(MathUtils.random(0, maxwidth), MathUtils.random(0, 
                            maxheight), duration / 2)); //移动方向和地点随机 
            Action rotateAction = RotateTo.$(360, duration); //旋转 
            Action fadeAction = Repeat.$(Sequence.$(FadeOut.$(duration / 20), 
                    FadeIn.$(duration / 20)), 10); //闪烁，重复10次 
            image.action(Parallel.$(moveAction, rotateAction, fadeAction)); //所有action并行 
            stage.addActor(image); 
        } 
        Gdx.input.setInputProcessor(stage); 
    }
 
    @Override
    public void dispose() { 
        texture.dispose(); 
        stage.dispose(); 
    }
 
    @Override
    public void pause() { 
        // TODO Auto-generated method stub
 
    }
 
    @Override
    public void render() { 
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); 
        stage.act(Gdx.graphics.getDeltaTime()); 
        stage.draw(); 
    }
 
    @Override
    public void resize(int width, int height) { 
        // TODO Auto-generated method stub
 
    }
 
    @Override
    public void resume() { 
        // TODO Auto-generated method stub
 
    }
 
}