package com.xogos2d.modelo;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by dam201 on 22/01/2015 13:12.
 */
public class Alien extends Personaxe {

    private Vector2 velocidade;
    private float velocidadeMontado;

    public static enum TIPOS_VIDA{
        INICIAL, SALVADO, MUERTO
    };

    private Array<TIPOS_VIDA> numVidas;

    public Alien(Vector2 posicion, Vector2 tamano, float velocidade_max){
        super(posicion, tamano, velocidade_max);

        velocidade = new Vector2(0,0);
        setVelocidade_montado(0);
        getRectangulo().setSize(tamano.x/2);
        numVidas = new Array<TIPOS_VIDA>();
    }

    public Array<TIPOS_VIDA> getNumVidas(){
        return numVidas;
    }

    public void setNumVidas(TIPOS_VIDA vida){
        numVidas.add(vida);
        /*
		 * poñer esta dependencia aqui igual no é moi correcto, o son vai no
		 * controlador do alien if (vida == TIPOS_VIDA.MUERTO) {
		 * Audio.morte.play(); } else if (vida == TIPOS_VIDA.SALVADO) {
		 * Audio.transporter_sfx.play(); }
		 */
    }

    public int getNumVidasSalvadas(){
        int num = 0;
        for(TIPOS_VIDA vida : numVidas){
            if(vida == TIPOS_VIDA.SALVADO){
                num++;
            }
        }
        return num;
    }

    public void inicializarAlien() {
        setPosicion(100, 20);
        setVelocidade_montado(0);
        setVelocidadeX(0);
        setVelocidadeY(0);
        setTamano(15, 15);
        getRectangulo().setSize(tamano.x / 2);
    }

    @Override
    public void actualizarRectangulo() {

        getRectangulo().x = getPosicion().x + getTamano().x / 4;
        getRectangulo().y = getPosicion().y + getTamano().y / 4;

    }

    public float getVelocidade_montado() {
        return velocidadeMontado;
    }

    public void setVelocidade_montado(float velocidade_montado) {
        this.velocidadeMontado = velocidade_montado;
    }

    public float getVelocidadeX() {
        return velocidade.x;
    }

    public float getVelocidadeY() {
        return velocidade.y;
    }

    public void setVelocidadeX(float x) {
        velocidade.x = x;

    }

    public void setVelocidadeY(float y) {
        velocidade.y = y;
    }

    @Override
    public void update(float delta) {
        // TODO Auto-generated method stub

        setPosicion(getPosicion().x + (velocidade.x + velocidadeMontado)
                * delta, getPosicion().y + velocidade.y * delta);

    }
}
