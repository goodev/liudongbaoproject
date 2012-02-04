package com.hellogame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.math.Rectangle;

public class CameraGame implements ApplicationListener {

	private OrthographicCamera cam;
	private Texture texture;
	private Mesh mesh;
	private Rectangle glViewport;

	@Override
	public void create() {
		// 创建一个静态的，由两个三角形构成的4个顶点的矩形
		// 矩形分为3*2块。网格有3个位置参数(x,y,z)
		// 网格的位置属性有两个值
		mesh = new Mesh(true, 4, 6, new VertexAttribute(
				VertexAttributes.Usage.Position, 3, "attr_Position"),
				new VertexAttribute(Usage.TextureCoordinates, 2,
						"attr_texCoords"));
		texture = new Texture(Gdx.files.internal("img/xk.jpg"));
		// 设置对应的边点
		// 以第一个为例-2048f，-2048f,0是位置参数，因为是二维的，所以Z值为0
		// 0,1对应顶点坐标
		mesh.setVertices(new float[] { -2048f, -2048f, 0, 0, 1, 2048f, -2048f,
				0, 1, 1, 2048f, 2048f, 0, 1, 0, -2048f, 2048f, 0, 0, 0 });
		// 设置索引，这个有点纠结，看文章详解
		mesh.setIndices(new short[] { 0, 1, 2, 2, 3, 0 });

		float WIDTH = Gdx.graphics.getWidth();
		float HEIGHT = Gdx.graphics.getHeight();

		cam = new OrthographicCamera(WIDTH, HEIGHT);
		cam.position.set(WIDTH / 2, HEIGHT / 2, 0);

		glViewport = new Rectangle(0, 0, WIDTH, HEIGHT);
	}

	@Override
	public void dispose() {

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {

		GL10 gl = Gdx.graphics.getGL10();
		// 相机移动
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		gl.glViewport((int) glViewport.x, (int) glViewport.y,
				(int) glViewport.width, (int) glViewport.height);

		cam.update();
		cam.apply(gl);
		// 贴图
		gl.glActiveTexture(GL10.GL_TEXTURE0);
		gl.glEnable(GL10.GL_TEXTURE_2D);
		texture.bind();

		mesh.render(GL10.GL_TRIANGLES);
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