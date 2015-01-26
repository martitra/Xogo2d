package com.xogos2d.modelo;

import com.badlogic.gdx.math.Vector2;

public class Nave extends Personaxe {

	private final int TEMPO_MOVENDOSE = 3;
	private float tempo;
	private boolean parado;

	public Nave(Vector2 posicion, Vector2 tamano, float velocidade_max) {
		super(posicion, tamano, velocidade_max);
		velocidade = velocidade_max;
		parado = false;
		tempo = 0;
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		if ((posicion.x > 33 && posicion.x < 35)
				|| (posicion.x > 133 && posicion.x < 135)
				|| (posicion.x > 227 && posicion.x < 229)) {
			parado = true;
		}
		if (parado) {
			tempo += delta;
			if (tempo > TEMPO_MOVENDOSE) {
				tempo = 0;
				parado = false;
			}
		}
		if (!parado) {
			setPosicion(getPosicion().x + delta * velocidade, getPosicion().y);

			// Se chega ó final do recorrido cambiamos de dirección
			if (posicion.x >= Mundo.TAMANO_MUNDO_ANCHO - getTamano().x) {
				setPosicion(Mundo.TAMANO_MUNDO_ANCHO - getTamano().x,
						getPosicion().y);
				velocidade = -1 * velocidade;
			} else if (posicion.x <= 0) {
				setPosicion(0, getPosicion().y);
				velocidade = -1 * velocidade;
			}
		}
	}

}
