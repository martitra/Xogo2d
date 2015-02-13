package com.xogos2d.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.xogos2d.controlador.ControladorXogo;
import com.xogos2d.dam.AssetsXogo;
import com.xogos2d.dam.Audio;
import com.xogos2d.dam.MeuXogoGame;
import com.xogos2d.dam.RendererXogo;
import com.xogos2d.dam.Utiles;
import com.xogos2d.modelo.Controis;
import com.xogos2d.modelo.Mundo;

public class PantallaXogo implements Screen, InputProcessor{
	
	private boolean pause;
	private boolean finXogo;
	private boolean sair;//finalizar

    private Vector3 temp;
    private Circle dedo;
	
	private MeuXogoGame meuXogoGame;
    private Mundo meuMundo;
	private RendererXogo rendererXogo;
    private ControladorXogo controladorXogo;
	
	public PantallaXogo(MeuXogoGame meuXogoGame){
		this.meuXogoGame = meuXogoGame;
        meuMundo = new Mundo();
        controladorXogo = new ControladorXogo(meuMundo);
        rendererXogo = new RendererXogo(meuMundo);

        temp = new Vector3();
        dedo = new Circle();

    }

	@Override
	public void show() {
		// TODO Auto-generated method stub
		//Utiles.imprimirLog("PantallaXogo", "SHOW", "Test");
        //indicamos a clase que inmplementa o interface InputProcessor
        Gdx.input.setInputProcessor(this);
        Audio.playMusica(); // iniciar música de fondo
        Audio.iniciarClaxon();

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		rendererXogo.render(delta);
        controladorXogo.update(delta);

        if (meuMundo.getAlien().getNumVidas().size >= 15) {
            finXogo = true;

        }

        if (pause) {
            meuXogoGame.setScreen(new PantallaPause(meuXogoGame,this));
            return;
        }

        if (finXogo) {
            meuXogoGame.setScreen(new PantallaMarcadores(meuXogoGame, this));
        }
		
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
		//Utiles.imprimirLog("PantallaXogo", "PAUSE", "Test");
        Gdx.input.setInputProcessor(null);
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		//Utiles.imprimirLog("PantallaXogo", "RESUME", "Test");
        Gdx.input.setInputProcessor(this);
        pause = false;
        Audio.playMusica();
        Audio.iniciarClaxon();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		//Utiles.imprimirLog("PantallaXogo", "HIDE", "Test");
        Gdx.input.setInputProcessor(null);
        Audio.pararClaxon();
        Audio.stopMusica();
        pause = false;
        if (finXogo || sair) dispose();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		//Utiles.imprimirLog("PantallaXogo", "DISPOSE", "Test");
        rendererXogo.dispose();
        Gdx.input.setInputProcessor(null);
	}

    @Override
    public boolean keyDown(int keycode) {

        // Liberar as teclas para que si arrastramos o dedo
        // ou outro control sen soltar o anterior, non xunte o efecto

        controladorXogo.liberarTecla(ControladorXogo.Keys.ABAIXO);
        controladorXogo.liberarTecla(ControladorXogo.Keys.ARRIBA);
        controladorXogo.liberarTecla(ControladorXogo.Keys.DEREITA);
        controladorXogo.liberarTecla(ControladorXogo.Keys.ESQUERDA);

        switch (keycode){
            case Input.Keys.UP:
                controladorXogo.pulsarTecla(ControladorXogo.Keys.ARRIBA);
                break;
            case Input.Keys.DOWN:
                controladorXogo.pulsarTecla(ControladorXogo.Keys.ABAIXO);
                break;
            case Input.Keys.RIGHT:
                controladorXogo.pulsarTecla(ControladorXogo.Keys.DEREITA);
                break;
            case Input.Keys.LEFT:
                controladorXogo.pulsarTecla(ControladorXogo.Keys.ESQUERDA);
                break;
        }


        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        controladorXogo.liberarTecla(ControladorXogo.Keys.ABAIXO);
        controladorXogo.liberarTecla(ControladorXogo.Keys.ARRIBA);
        controladorXogo.liberarTecla(ControladorXogo.Keys.DEREITA);
        controladorXogo.liberarTecla(ControladorXogo.Keys.ESQUERDA);

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        OrthographicCamera camara2d = rendererXogo.getCamara2d();
        temp.set(screenX, screenY, 0);
        camara2d.unproject(temp);
        dedo.set(temp.x, temp.y, 2f);

        // liberar as teclas
        controladorXogo.liberarTecla(ControladorXogo.Keys.ABAIXO);
        controladorXogo.liberarTecla(ControladorXogo.Keys.ARRIBA);
        controladorXogo.liberarTecla(ControladorXogo.Keys.DEREITA);
        controladorXogo.liberarTecla(ControladorXogo.Keys.ESQUERDA);
        //

        if(Intersector.overlaps(dedo, Controis.getRectanguloFrechaEsquerda())) {
            controladorXogo.pulsarTecla(ControladorXogo.Keys.ESQUERDA);
        } else if (Intersector.overlaps(dedo, Controis.getRectanguloFrechaAbaixo())) {
            controladorXogo.pulsarTecla(ControladorXogo.Keys.ABAIXO);
        } else if (Intersector.overlaps(dedo, Controis.getRectanguloFrechaArriba())) {
            controladorXogo.pulsarTecla(ControladorXogo.Keys.ARRIBA);
        } else if (Intersector.overlaps(dedo, Controis.getRectanguloFrechaDereita())) {
            controladorXogo.pulsarTecla(ControladorXogo.Keys.DEREITA);
        } else if (Intersector.overlaps(dedo, Controis.CONTROL_PAUSE)) {
            pause = true;
        } else if (Intersector.overlaps(dedo, Controis.CONTROL_SAIR)) {
            sair = true;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

	
}
