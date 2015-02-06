package com.xogos2d.modelo;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by dam201 on 06/02/2015 14:09.
 */
public class Controis {

    //define fondo negro
    public final static Rectangle FONDO_NEGRO = new Rectangle(0, 0,
            Mundo.TAMANO_MUNDO_ANCHO, 12);

    public final static Rectangle CONTROL = new Rectangle(10, 40, 50, 70);
    public final static int POSVIDAS = 60;

    public final static Rectangle CONTROL_PAUSE = new Rectangle(5,0,10,10);
    public final static Rectangle CONTROL_SAIR = new Rectangle(18,0,10,10);



    public static Rectangle getRectanguloFrechaEsquerda() {
        return new Rectangle(Controis.CONTROL.x, Controis.CONTROL.y
                + Controis.CONTROL.height / 3, Controis.CONTROL.width / 2,
                Controis.CONTROL.height / 3);
    }

    public static Rectangle getRectanguloFrechaDereita() {
        return new Rectangle(Controis.CONTROL.x + Controis.CONTROL.width / 2,
                Controis.CONTROL.y + Controis.CONTROL.height / 3,
                Controis.CONTROL.width / 2, Controis.CONTROL.height / 3);
    }

    public static Rectangle getRectanguloFrechaArriba() {
        return new Rectangle(Controis.CONTROL.x, Controis.CONTROL.y
                + Controis.CONTROL.height * 2 / 3, Controis.CONTROL.width,
                Controis.CONTROL.height / 3);

    }

    public static Rectangle getRectanguloFrechaAbaixo() {
        return new Rectangle(Controis.CONTROL.x, Controis.CONTROL.y,
                Controis.CONTROL.width, Controis.CONTROL.height / 3);
    }

}
