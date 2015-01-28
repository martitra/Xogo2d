package com.xogos2d.pantallas;

import com.badlogic.gdx.Screen;
import com.xogos2d.controlador.ControladorXogo;
import com.xogos2d.dam.AssetsXogo;
import com.xogos2d.dam.MeuXogoGame;
import com.xogos2d.dam.RendererXogo;
import com.xogos2d.dam.Utiles;
import com.xogos2d.modelo.Mundo;

public class PantallaXogo implements Screen{
	
	private boolean pause;
	private boolean finXogo;
	private boolean sair;//finalizar
	
	private MeuXogoGame meuXogoGame;
    private Mundo meuMundo;
	private RendererXogo rendererXogo;
    private ControladorXogo controladorXogo;
	
	public PantallaXogo(MeuXogoGame meuXogoGame){
		this.meuXogoGame = meuXogoGame;
        meuMundo = new Mundo();
        controladorXogo = new ControladorXogo(meuMundo);
        rendererXogo = new RendererXogo(meuMundo);

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		Utiles.imprimirLog("PantallaXogo", "SHOW", "Test");
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		rendererXogo.render(delta);
        controladorXogo.update(delta);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		rendererXogo.resize(width, height);
		//Utiles.imprimirLog("PantallaXogo", "RESIZE", "Test");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Utiles.imprimirLog("PantallaXogo", "PAUSE", "Test");
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		Utiles.imprimirLog("PantallaXogo", "RESUME", "Test");
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		Utiles.imprimirLog("PantallaXogo", "HIDE", "Test");
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		rendererXogo.dispose();
		//Utiles.imprimirLog("PantallaXogo", "DISPOSE", "Test");
		
	}

	
}
