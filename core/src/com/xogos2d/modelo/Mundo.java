package com.xogos2d.modelo;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.xogos2d.modelo.ElementoMobil.TIPOS_ELEMENTOS;

public final class Mundo {
	public static final int TAMANO_MUNDO_ANCHO = 300;
	public static final int TAMANO_MUNDO_ALTO = 500;

	public final static Vector2 TAMANO_COCHES = new Vector2(20, 15);
	public final static Vector2 TAMANO_AUTOBUSES = new Vector2(30, 15);
	public final static Vector2 TAMANO_ROCA = new Vector2(60, 60);
	public final static Vector2 TAMANO_TRONCO = new Vector2(80, 40);

	public static final Rectangle ZONAS_PERIGOSAS[] = {
			new Rectangle(0, 40, 300, 120), new Rectangle(0, 220, 300, 120),
			new Rectangle(0, 420, 300, 80) };
	public static final Rectangle ZONAS_SEGURAS[] = {
			new Rectangle(40, 420, 20, 60), new Rectangle(140, 420, 20, 60),
			new Rectangle(240, 420, 20, 60) };
	// AS PLATAFORMAS QUE ESTAN ENRIBA DA LAVA.

	private Array<ElementoMobil> coches;
	private Array<ElementoMobil> rochas;
	private Array<ElementoMobil> troncos;

	private Alien alien;
	private Nave nave;

	private final static int TEMPO_INICIAL = 120;
	private float cronometro;

	public Mundo() {
		alien = new Alien(new Vector2(100, 20), new Vector2(15, 15), 100);
		nave = new Nave(new Vector2(0, 480), new Vector2(40, 20), 60f);

		coches = new Array<ElementoMobil>();

		coches.add(new ElementoMobil(new Vector2(0, 345), TAMANO_AUTOBUSES
				.cpy(), 50, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));
		//coches.add(new ElementoMobil(new Vector2(70, 345), TAMANO_COCHES.cpy(),
		//		50, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		coches.add(new ElementoMobil(new Vector2(95, 345), TAMANO_COCHES.cpy(),
				50, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		coches.add(new ElementoMobil(new Vector2(115, 345),
				TAMANO_COCHES.cpy(), 50, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		//coches.add(new ElementoMobil(new Vector2(140, 345), TAMANO_AUTOBUSES
		//		.cpy(), 50, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));
		coches.add(new ElementoMobil(new Vector2(210, 345), TAMANO_AUTOBUSES
				.cpy(), 50, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));
		coches.add(new ElementoMobil(new Vector2(240, 345),
				TAMANO_COCHES.cpy(), 50, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		//coches.add(new ElementoMobil(new Vector2(278, 345),
		//		TAMANO_COCHES.cpy(), 50, ElementoMobil.TIPOS_ELEMENTOS.COCHE));

		coches.add(new ElementoMobil(new Vector2(40, 380), TAMANO_COCHES.cpy(),
				35, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		coches.add(new ElementoMobil(new Vector2(70, 380), TAMANO_COCHES.cpy(),
				35, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		//coches.add(new ElementoMobil(new Vector2(105, 380),
		//		TAMANO_COCHES.cpy(), 35, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		coches.add(new ElementoMobil(new Vector2(150, 380), TAMANO_AUTOBUSES
				.cpy(), 35, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));
		//coches.add(new ElementoMobil(new Vector2(180, 380), TAMANO_AUTOBUSES
		//		.cpy(), 35, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));
		coches.add(new ElementoMobil(new Vector2(220, 380),
				TAMANO_COCHES.cpy(), 35, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		coches.add(new ElementoMobil(new Vector2(265, 380), TAMANO_AUTOBUSES
				.cpy(), 35, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));

		// //////////

		coches.add(new ElementoMobil(new Vector2(0, 400), TAMANO_AUTOBUSES
				.cpy(), -45, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));
		//coches.add(new ElementoMobil(new Vector2(30, 400), TAMANO_COCHES.cpy(),
		//		-45, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		coches.add(new ElementoMobil(new Vector2(70, 400), TAMANO_COCHES.cpy(),
				-45, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		//coches.add(new ElementoMobil(new Vector2(95, 400), TAMANO_COCHES.cpy(),
		//		-45, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		coches.add(new ElementoMobil(new Vector2(115, 400),
				TAMANO_COCHES.cpy(), -45, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		//coches.add(new ElementoMobil(new Vector2(140, 400), TAMANO_AUTOBUSES
		//		.cpy(), -45, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));
		//coches.add(new ElementoMobil(new Vector2(210, 400), TAMANO_AUTOBUSES
		//		.cpy(), -45, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));
		coches.add(new ElementoMobil(new Vector2(240, 400),
				TAMANO_COCHES.cpy(), -45, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		coches.add(new ElementoMobil(new Vector2(278, 400),
				TAMANO_COCHES.cpy(), -45, ElementoMobil.TIPOS_ELEMENTOS.COCHE));

		//coches.add(new ElementoMobil(new Vector2(0, 365), TAMANO_COCHES.cpy(),
		//		-65, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		coches.add(new ElementoMobil(new Vector2(70, 365), TAMANO_AUTOBUSES
				.cpy(), -65, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));
		coches.add(new ElementoMobil(new Vector2(115, 365),
				TAMANO_COCHES.cpy(), -65, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		//coches.add(new ElementoMobil(new Vector2(140, 365), TAMANO_AUTOBUSES
		//		.cpy(), -65, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));
		coches.add(new ElementoMobil(new Vector2(240, 365),
				TAMANO_COCHES.cpy(), -65, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		coches.add(new ElementoMobil(new Vector2(278, 365), TAMANO_AUTOBUSES
				.cpy(), -65, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));

		// //
		coches.add(new ElementoMobil(new Vector2(0, 365), TAMANO_COCHES.cpy(),
				-65, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		//coches.add(new ElementoMobil(new Vector2(70, 365), TAMANO_AUTOBUSES
		//		.cpy(), -65, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));
		//coches.add(new ElementoMobil(new Vector2(115, 365),
		//		TAMANO_COCHES.cpy(), -65, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		coches.add(new ElementoMobil(new Vector2(140, 365), TAMANO_AUTOBUSES
				.cpy(), -65, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));
		coches.add(new ElementoMobil(new Vector2(240, 365),
				TAMANO_COCHES.cpy(), -65, ElementoMobil.TIPOS_ELEMENTOS.COCHE));
		coches.add(new ElementoMobil(new Vector2(278, 365), TAMANO_AUTOBUSES
				.cpy(), -65, ElementoMobil.TIPOS_ELEMENTOS.AUTOBUS));

		//
		rochas = new Array<ElementoMobil>();
		rochas.add(new ElementoMobil(new Vector2(0, 40), TAMANO_ROCA.cpy(), 40,
				ElementoMobil.TIPOS_ELEMENTOS.ROCA));
		rochas.add(new ElementoMobil(new Vector2(0, 100), TAMANO_ROCA.cpy(),
				-60, ElementoMobil.TIPOS_ELEMENTOS.ROCA));
        rochas.add(new ElementoMobil(new Vector2(0, 40), TAMANO_ROCA.cpy(), 40,
                ElementoMobil.TIPOS_ELEMENTOS.ROCA));
        rochas.add(new ElementoMobil(new Vector2(0, 100), TAMANO_ROCA.cpy(),
                -60, ElementoMobil.TIPOS_ELEMENTOS.ROCA));
		//
		troncos = new Array<ElementoMobil>();
		troncos.add(new ElementoMobil(new Vector2(100, 220), TAMANO_TRONCO
				.cpy(), -50, ElementoMobil.TIPOS_ELEMENTOS.TRONCO));
		troncos.add(new ElementoMobil(new Vector2(60, 260),
				TAMANO_TRONCO.cpy(), 40, ElementoMobil.TIPOS_ELEMENTOS.TRONCO));
		troncos.add(new ElementoMobil(new Vector2(150, 300), TAMANO_TRONCO
				.cpy(), -70, ElementoMobil.TIPOS_ELEMENTOS.TRONCO));
        troncos.add(new ElementoMobil(new Vector2(100, 220), TAMANO_TRONCO
                .cpy(), -50, ElementoMobil.TIPOS_ELEMENTOS.TRONCO));
        troncos.add(new ElementoMobil(new Vector2(60, 260),
                TAMANO_TRONCO.cpy(), 40, ElementoMobil.TIPOS_ELEMENTOS.TRONCO));
        troncos.add(new ElementoMobil(new Vector2(150, 300), TAMANO_TRONCO
                .cpy(), -70, ElementoMobil.TIPOS_ELEMENTOS.TRONCO));
		/*
		 * coches.add(new ElementoMobil(new Vector2(10, 400), new Vector2(20,
		 * 15), 65, TIPOS_ELEMENTOS.COCHE)); coches.add(new ElementoMobil(new
		 * Vector2(40, 400), new Vector2(20, 15), 65, TIPOS_ELEMENTOS.COCHE));
		 */

		cronometro = TEMPO_INICIAL;
	}

	public Array<ElementoMobil> getCoches() {
		return coches;
	}

	public Array<ElementoMobil> getTroncos() {
		return troncos;
	}

	public Array<ElementoMobil> getRochas() {
		return rochas;
	}

	public Alien getAlien() {
		return alien;
	}

	public Nave getNave() {
		return nave;
	}

	public int getCronometro() {
		return (int) cronometro;
	}

	public void setCronometro(float cronometro) {
		this.cronometro = cronometro;
	}

	public void updateCronometro(float delta) {
		cronometro -= delta;
	}

}
