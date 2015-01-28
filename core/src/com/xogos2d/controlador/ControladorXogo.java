package com.xogos2d.controlador;

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

    private void controladorRochas(float delta){
        for (ElementoMobil rocha : meuMundo.getRochas()){
            rocha.update(delta);
            if (rocha.getPosicion().x < -Mundo.TAMANO_ROCA.x){
                meuMundo.getRochas().add(rocha);
            }
        }
    }

    public void update(float delta){
        controladorRochas(delta);

    }
}
