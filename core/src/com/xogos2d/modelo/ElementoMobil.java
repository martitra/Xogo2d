package com.xogos2d.modelo;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by dam201 on 26/01/2015.
 */
public class ElementoMobil extends Personaxe {

    public static enum TIPOS_ELEMENTOS{
        COCHE, AUTOBUS, TRONCO, ROCA;
    };

    private TIPOS_ELEMENTOS tipo;

    public ElementoMobil(Vector2 posicion, Vector2 tamano, float velocidade_max, TIPOS_ELEMENTOS tipo){
        super(posicion, tamano, velocidade_max);
        setVelocidade(velocidade_max);
        this.tipo = tipo;
    }

    public TIPOS_ELEMENTOS getTipo(){
        return tipo;
    }

    @Override
    public void update(float delta){
        posicion.add((velocidade*delta),0);//solo cambiamos la posicion x porque se mueve en horizontal
    }


}
