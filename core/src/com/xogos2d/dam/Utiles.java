package com.xogos2d.dam;

import com.badlogic.gdx.Gdx;

public class Utiles {
	
	private static final String LOG = "Xogo2D";

	public static void imprimirLog(String clase, String metodo, String mensaxe){
		Gdx.app.log(LOG, clase+":" + metodo + ":" + mensaxe);//o noso log
	}
	
}
