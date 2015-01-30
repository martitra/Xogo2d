package com.xogos2d.controlador;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.xogos2d.modelo.Alien;
import com.xogos2d.modelo.ElementoMobil;
import com.xogos2d.modelo.Mundo;

/**
 * Created by dam201 on 28/01/2015.
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
        }
    }

    public void update(float delta){
        controladorRochas(delta);

    }
}
