package com.xogos2d.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.xogos2d.dam.MeuXogoGame;
import com.xogos2d.modelo.Mundo;

public class PantallaMarcadores implements Screen, InputProcessor {

    /* TODO Poner resultado de juego */

    MeuXogoGame meuXogoGame;
    PantallaXogo pantallaXogo;
    OrthographicCamera camara2d;
    SpriteBatch spriteBatch;
    Texture fondo;

    public PantallaMarcadores(MeuXogoGame meuXogoGame, PantallaXogo pantallaXogo){
        this.meuXogoGame = meuXogoGame;
        this.pantallaXogo = pantallaXogo;
        camara2d = new OrthographicCamera();
        spriteBatch = new SpriteBatch();
        fondo = new Texture(Gdx.files.internal("GRAFICOS/LIBGDX_itin1_pantallapause.jpg"));
    }

    @Override
    public boolean keyDown(int keycode) {

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
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

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render(float delta) {
        spriteBatch.begin();
        spriteBatch.draw(fondo,0,0, Mundo.TAMANO_MUNDO_ANCHO,Mundo.TAMANO_MUNDO_ALTO);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        camara2d.setToOrtho(false, Mundo.TAMANO_MUNDO_ANCHO, Mundo.TAMANO_MUNDO_ALTO);
        camara2d.update();
        spriteBatch.setProjectionMatrix(camara2d.combined);
        spriteBatch.disableBlending();
    }

    @Override
    public void pause() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void resume() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        spriteBatch.dispose();
        fondo.dispose();
    }
}
