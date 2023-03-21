package model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 16/03/2023
* Ultima alteracao.: 20/03/2023
* Nome.............: Jukebox
* Funcao...........: Onde fica musica que vai tocar
*************************************************************** */
public abstract class Jukebox {

	/**
	 * @var DIRETORIO : diretorio aonde se encontra a musica no projeto
	 */
	private static final String DIRETORIO = "pc_trabalho02_202110838/thread/view/music/";
	private static  Clip clip; // audio

	public static void play (String string) {
		try {
			File audio = new File (Jukebox.class.getClassLoader().getResource(DIRETORIO + string).getFile());
			if (audio.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(audio);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start();
			} else {
				System.out.println("Audio NAO encontrado!");
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void pause() {
		if (clip != null) {
			if(clip.isRunning()) {
				clip.stop();
			} else {
				clip.start();
			}
		}
	}


}
