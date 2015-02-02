package com.xogos2d.controlador;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.xogos2d.dam.Utiles;
import com.xogos2d.modelo.Alien;
import com.xogos2d.modelo.ElementoMobil;
import com.xogos2d.modelo.Mundo;

/**
 * Created by dam201 on 28/01/2015 14:08 14:08.
 */
public class ControladorXogo {
    private Mundo meuMundo;
    private Alien alien;


    public ControladorXogo(Mundo meuMundo) {
        this.meuMundo = meuMundo;
        alien = meuMundo.getAlien();
    }

    /*
    creamos unha nova rocha antes de elimnala
    Random : xera un nº aleatorio entre o tamaño do mundo e o
    tamaño do mundo + ancho da rocha
     */
    private void controladorRochas(float delta){
        for (ElementoMobil rocha : meuMundo.getRochas()){
            rocha.update(delta);
            // comprobamos que a rocha alcanza o límite
            // ven de dereita a esquerda
            if (rocha.getPosicion().x < -Mundo.TAMANO_ROCA.x){
                /*
                creamos una nova rocha antes de eliminsarla
                Random: xera un nº aleatorio entre o tamaño do mundo e
                o tamaño do mundo + ancho da rocha
                */
                meuMundo.getRochas().add(
                    new ElementoMobil(
                        new Vector2(MathUtils.random(Mundo.TAMANO_MUNDO_ANCHO,
                                Mundo.TAMANO_MUNDO_ANCHO + Mundo.TAMANO_ROCA.x),
                                rocha.getPosicion().y
                        ),
                        Mundo.TAMANO_ROCA.cpy(),
                        rocha.getVelocidade(),
                        ElementoMobil.TIPOS_ELEMENTOS.ROCA
                    )
                );
                meuMundo.getRochas().removeValue(rocha, true);
            }
            // Comprobamos límite de esquerda a dereita
            if (rocha.getPosicion().x > Mundo.TAMANO_MUNDO_ANCHO){
                /*
                creamos una nova rocha antes de eliminsarla
                Random: xera un nº aleatorio entre o tamaño do mundo e
                o tamaño do mundo + ancho da rocha
                */
                meuMundo.getRochas().add(
                        new ElementoMobil(
                                new Vector2(MathUtils.random(-2*Mundo.TAMANO_ROCA.x,
                                        -Mundo.TAMANO_ROCA.x),
                                        rocha.getPosicion().y
                                ),
                                Mundo.TAMANO_ROCA.cpy(),
                                rocha.getVelocidade(),
                                ElementoMobil.TIPOS_ELEMENTOS.ROCA
                        )
                );
                //Utiles.imprimirLog("ControladorXogo", "ROCHA","log rocha");//log
                meuMundo.getRochas().removeValue(rocha, true);
            }
        }
    }

    private void controladorTroncos(float delta){
        for (ElementoMobil tronco : meuMundo.getTroncos()){
            tronco.update(delta);
            // comprobamos que o tronco alcanza o límite
            // ven de dereita a esquerda
            if (tronco.getPosicion().x < -Mundo.TAMANO_TRONCO.x){
                /*
                creamos un novo tronco antes de eliminarlo
                Random: xera un nº aleatorio entre o tamaño do mundo e
                o tamaño do mundo + ancho do tronco
                */
                meuMundo.getTroncos().add(
                        new ElementoMobil(
                                new Vector2(MathUtils.random(Mundo.TAMANO_MUNDO_ANCHO,
                                        Mundo.TAMANO_MUNDO_ANCHO + Mundo.TAMANO_TRONCO.x),
                                        tronco.getPosicion().y
                                ),
                                Mundo.TAMANO_TRONCO.cpy(),
                                tronco.getVelocidade(),
                                ElementoMobil.TIPOS_ELEMENTOS.TRONCO
                        )
                );
                meuMundo.getTroncos().removeValue(tronco, true);
            }
            // Comprobamos límite de esquerda a dereita
            if (tronco.getPosicion().x > Mundo.TAMANO_MUNDO_ANCHO){
                /*
                creamos un novo tronco antes de eliminarlo
                Random: xera un nº aleatorio entre o tamaño do mundo e
                o tamaño do mundo + ancho do tronco
                */
                meuMundo.getTroncos().add(
                        new ElementoMobil(
                                new Vector2(MathUtils.random(-2*Mundo.TAMANO_TRONCO.x,
                                        -Mundo.TAMANO_TRONCO.x),
                                        tronco.getPosicion().y
                                ),
                                Mundo.TAMANO_TRONCO.cpy(),
                                tronco.getVelocidade(),
                                ElementoMobil.TIPOS_ELEMENTOS.TRONCO
                        )
                );
                //Utiles.imprimirLog("ControladorXogo", "ROCHA","log rocha");//log
                meuMundo.getTroncos().removeValue(tronco, true);
            }
        }
    }


    private void controladorCoches(float delta){

        for (ElementoMobil coche :meuMundo.getCoches()){
            coche.update(delta);
            if(coche.getVelocidade() > 0 ){ // vai de esquerda a dereita
                if (coche.getPosicion().x >= Mundo.TAMANO_MUNDO_ANCHO){
                    coche.setPosicion(MathUtils.random(-2*Mundo.TAMANO_AUTOBUSES.x,
                                    -Mundo.TAMANO_AUTOBUSES.x),
                            //-Mundo.TAMANO_AUTOBUSES.x,
                            coche.getPosicion().y);
                }
            }
            else {//de dereita a esquerda
                if (coche.getPosicion().x <= -coche.getTamano().x){
                    coche.setPosicion(MathUtils.random(Mundo.TAMANO_MUNDO_ANCHO,
                                    Mundo.TAMANO_MUNDO_ANCHO + Mundo.TAMANO_AUTOBUSES.x),
                            coche.getPosicion().y);
                }
            }
        }
    }

    private void controladorNave(float delta){
        meuMundo.getNave().update(delta);
    }

    public void update(float delta){
        controladorRochas(delta);
        controladorTroncos(delta);
        controladorCoches(delta);
        controladorNave(delta);

    }
}
