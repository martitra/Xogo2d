package com.xogos2d.dam;

import com.badlogic.gdx.Game;
import com.xogos2d.pantallas.PantallaPresentacion;
import com.xogos2d.pantallas.PantallaXogo;

public class MeuXogoGame extends Game {

	
	//private PantallaXogo pantallaXogo;
    private PantallaPresentacion pantallaPresentacion;

	@Override
	public void create() {
		// TODO Auto-generated method stub

        AssetsXogo.cargarTexturas();
        Audio.inicializarMusica();

		//pantallaXogo = new PantallaXogo(this);//para eliminar pantalla al cerrarla y no hide sino dispose
		//setScreen(pantallaXogo);
        pantallaPresentacion = new PantallaPresentacion(this);
        setScreen(pantallaPresentacion);
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Game#dispose()
	 */
	@Override
	public void dispose() {//libera memoria, liberar recursos de memoria
		// TODO Auto-generated method stub
		super.dispose();
		//pantallaXogo.dispose();//facermos esto para no hide sino dispose
        pantallaPresentacion.dispose();

        AssetsXogo.liberarTexturas();
        Audio.dispose();
		
	}
	
}
