package com.xogos2d.dam.desktop;

import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.xogos2d.dam.MeuXogo;
import com.xogos2d.dam.MeuXogoGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "O meu Xogo";
		config.width = 480;
		config.height = 800;
		DisplayMode displayMode = LwjglApplicationConfiguration.getDesktopDisplayMode();
		//config.width = displayMode.width;
		//config.height = displayMode.height;
		//config.fullscreen = true;//ALT+F4 para salir de pantalla completa
		new LwjglApplication(new MeuXogoGame(), config);//cambiar por meuxogogame en vez de meuxogo
	}
}
