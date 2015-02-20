package com.xogos2d.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.xogos2d.dam.Audio;
import com.xogos2d.dam.MeuXogoGame;
import com.xogos2d.modelo.Mundo;

public class PantallaPresentacion implements Screen, InputProcessor{

    private MeuXogoGame meuXogoGame;
    private OrthographicCamera camara2d;
    private SpriteBatch spriteBatch;
    private static Texture fondo;

    private Rectangle botons[] = {
            new Rectangle(100, 268, 98, 32),
            new Rectangle(100, 235, 98, 32),
            new Rectangle(100, 200, 98, 32)
    };

    Vector3 temp;
    Circle dedo;

    public PantallaPresentacion(MeuXogoGame meuXogoGame){
        this.meuXogoGame = meuXogoGame;
        camara2d = new OrthographicCamera();
        spriteBatch = new SpriteBatch();
        fondo = new Texture(Gdx.files.internal("GRAFICOS/LIBGDX_itin1_pantallapresentacion.png"));
        temp = new Vector3();
        dedo = new Circle();

        Audio.playMusica();

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
        temp.set(screenX,screenY,0);
        camara2d.unproject(temp);
        dedo.setPosition(temp.x,temp.y);
        dedo.setRadius(2f);
        if (Intersector.overlaps(dedo,botons[0])) {
            // novo xogo
            meuXogoGame.setScreen(new PantallaXogo(meuXogoGame));
        } else if (Intersector.overlaps(dedo,botons[1])) {
            // segunda opción, marcadores
        } else if (Intersector.overlaps(dedo,botons[2])) {
            // salir
            Gdx.app.exit();
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
        camara2d.setToOrtho(false,Mundo.TAMANO_MUNDO_ANCHO,
                Mundo.TAMANO_MUNDO_ALTO);
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
        //spriteBatch.dispose();
        fondo.dispose();
    }
}
