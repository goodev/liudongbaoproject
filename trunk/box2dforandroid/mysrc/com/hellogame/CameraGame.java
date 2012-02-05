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
		// ����һ����̬�ģ������������ι��ɵ�4������ľ���
		// ���η�Ϊ3*2�顣������3��λ�ò���(x,y,z)
		// �����λ������������ֵ
		mesh = new Mesh(true, 4, 6, new VertexAttribute(
				VertexAttributes.Usage.Position, 3, "attr_Position"),
				new VertexAttribute(Usage.TextureCoordinates, 2,
						"attr_texCoords"));
		texture = new Texture(Gdx.files.internal("img/xk.jpg"));
		// ���ö�Ӧ�ıߵ�
		// �Ե�һ��Ϊ��-2048f��-2048f,0��λ�ò�������Ϊ�Ƕ�ά�ģ�����ZֵΪ0
		// 0,1��Ӧ��������
		mesh.setVertices(new float[] { -2048f, -2048f, 0, 0, 1, 2048f, -2048f,
				0, 1, 1, 2048f, 2048f, 0, 1, 0, -2048f, 2048f, 0, 0, 0 });
		// ��������������е���ᣬ���������
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
		// ����ƶ�
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		gl.glViewport((int) glViewport.x, (int) glViewport.y,
				(int) glViewport.width, (int) glViewport.height);

		cam.update();
		cam.apply(gl);
		// ��ͼ
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