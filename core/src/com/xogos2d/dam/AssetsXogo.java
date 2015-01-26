package com.xogos2d.dam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class AssetsXogo {
	public static Texture textureAlien;
	public static Texture textureAlienDead;
	public static Texture textureAlienRescue;
	public static Texture textureAutobus;
	public static Texture textureCoche;
	public static Texture textureFondo;
	public static Texture textureNave;
	public static Texture textureRoca;
	public static Texture textureTronco;
	public static Texture texturePuntoNegro;
	public static Texture textureControisFrechas;
	public static Texture texturePausa;
	public static Texture textureSair;
	
	public static void cargarTexturas() {
		FileHandle imageFileHandle;
		
		imageFileHandle = Gdx.files
				.internal("GRAFICOS/LIBGDX_itin1_alien.png");
		textureAlien = new Texture(imageFileHandle);
		
		imageFileHandle = Gdx.files
				.internal("GRAFICOS/LIBGDX_itin1_alien_dead.png");
		textureAlienDead = new Texture(imageFileHandle);
		
		imageFileHandle = Gdx.files
				.internal("GRAFICOS/LIBGDX_itin1_alien_rescue.png");
		textureAlienRescue = new Texture(imageFileHandle);
		
		imageFileHandle = Gdx.files
				.internal("GRAFICOS/LIBGDX_itin1_autobus1.png");
		textureAutobus = new Texture(imageFileHandle);
		
		imageFileHandle = Gdx.files
				.internal("GRAFICOS/LIBGDX_itin1_coche1.png");
		textureCoche = new Texture(imageFileHandle);
		
		imageFileHandle = Gdx.files
				.internal("GRAFICOS/LIBGDX_itin1_fondoxogo.jpg");
		textureFondo = new Texture(imageFileHandle);
		
		imageFileHandle = Gdx.files
				.internal("GRAFICOS/LIBGDX_itin1_nave.png");
		textureNave = new Texture(imageFileHandle);
		
		imageFileHandle = Gdx.files
				.internal("GRAFICOS/LIBGDX_itin1_roca.png");
		textureRoca = new Texture(imageFileHandle);
		
		imageFileHandle = Gdx.files
				.internal("GRAFICOS/LIBGDX_itin1_tronco.jpg");
		textureTronco = new Texture(imageFileHandle);
		
		imageFileHandle = Gdx.files
				.internal("GRAFICOS/LIBGDX_puntonegro.jpg");
		texturePuntoNegro = new Texture(imageFileHandle);
		
		imageFileHandle = Gdx.files
				.internal("GRAFICOS/CONTROIS/LIBGDX_itin1_controis.png");
		textureControisFrechas = new Texture(imageFileHandle);
	
		imageFileHandle = Gdx.files
				.internal("GRAFICOS/CONTROIS/LIBGDX_itin1_pausa.png");
		texturePausa = new Texture(imageFileHandle);
		
		imageFileHandle = Gdx.files
				.internal("GRAFICOS/CONTROIS/LIBGDX_itin1_sair.png");
		textureSair = new Texture(imageFileHandle);
	}

	public static void liberarTexturas() {
		textureAlien.dispose();
		textureAlienDead.dispose();
		textureAlienRescue.dispose();
		textureAutobus.dispose();
		textureCoche.dispose();
		textureFondo.dispose();
		textureNave.dispose();
		textureRoca.dispose();
		textureTronco.dispose();
		texturePuntoNegro.dispose();
		textureControisFrechas.dispose();
		
	}
}
