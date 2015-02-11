package com.xogos2d.dam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by dam201 on 09/02/2015 14:30.
 */
public class Audio {

    public static Music grapes_dunno;
    public static Music oceans_sound;

    public static Sound morte;
    public static Sound transporter_sfx;

    public static Sound claxon[] = new Sound[3];

    private static Timer.Task claxonCoches;

    public Audio(){
        super();
    }

    public static void inicializarMusica() { // es estático y no se pone en el constructor

        grapes_dunno = Gdx.audio.newMusic(Gdx.files

                .internal("MUSICA/LIBGDX_grapes_I_dunno_m.mp3"));

        oceans_sound = Gdx.audio.newMusic(Gdx.files

                .internal("MUSICA/LIBGDX_ocean_sounds.mp3"));

        morte = Gdx.audio.newSound(Gdx.files

                .internal("MUSICA/LIBGDX_morte.mp3"));

        transporter_sfx = Gdx.audio.newSound(Gdx.files

                .internal("MUSICA/LIBGDX_transporter_sfx.mp3"));

        claxon[0] = Gdx.audio.newSound(Gdx.files

                .internal("MUSICA/LIBGDX_claxon.mp3"));

        claxon[1] = Gdx.audio.newSound(Gdx.files

                .internal("MUSICA/LIBGDX_claxon2.mp3"));

        claxon[2] = Gdx.audio.newSound(Gdx.files

                .internal("MUSICA/LIBGDX_claxon3.mp3"));

    }

    public static void playMusica() {

        grapes_dunno.setVolume(0.5f);
        grapes_dunno.setLooping(true);
        grapes_dunno.play();

    }

    public static void stopMusica() {

        grapes_dunno.stop();

    }

    public static void iniciarClaxon() {

        claxonCoches = new Timer.Task() {
            @Override
            public void run() {

                Audio.claxon[MathUtils.random(0,2)].play();

            }
        };
        Timer.schedule(claxonCoches,0,2f);

    }

    public static void pararClaxon() {

        claxonCoches.cancel();
    }

    public static void dispose() {

        grapes_dunno.dispose();
        oceans_sound.dispose();
        morte.dispose();
        transporter_sfx.dispose();
        claxon[0].dispose();
        claxon[1].dispose();
        claxon[2].dispose();

    }

}
