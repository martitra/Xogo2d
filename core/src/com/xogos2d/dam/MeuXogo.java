package com.xogos2d.dam;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//heredar de game en vez de apllicationAdapter facenso referecia a outra clase
public class MeuXogo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	//private FPSLogger fps;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		//fps = new FPSLogger();
		
		Utiles.imprimirLog("MeuXogo", "create", "text");
	}

	@Override
	public void render () {
		//fps.log();//fps frames per second
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationAdapter#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		super.resize(width, height);
		Utiles.imprimirLog("MeuXogo", "resize", "text");
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationAdapter#pause()
	 */
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
		Utiles.imprimirLog("MeuXogo", "pause", "text");
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationAdapter#resume()
	 */
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		super.resume();
		Utiles.imprimirLog("MeuXogo", "resume", "text");
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationAdapter#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		Utiles.imprimirLog("MeuXogo", "disposes", "text");
	}
}
