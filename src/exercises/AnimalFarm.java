package exercises;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class AnimalFarm {

	AnimalFarm() {
		while (true) {
			String animal = JOptionPane.showInputDialog(null, "Which animal do you want?");

			if (animal.isEmpty()) {
				System.exit(0);
			}
			if (animal.equalsIgnoreCase("duck")) {
				playQuack();
			} else if (animal.equalsIgnoreCase("cow")) {
				playMoo();
			} else if (animal.equalsIgnoreCase("dog")) {
				playWoof();
			} else if (animal.equalsIgnoreCase("cat")) {
				playMeow();
			} else if (animal.equalsIgnoreCase("llama")) {
				playLlama();
			} else {
				JOptionPane.showMessageDialog(null, "Animal not found,try again");
			}
		}
	}

	void playMoo() {
		playNoise(mooFile);
	}

	void playQuack() {
		playNoise(quackFile);
	}

	void playWoof() {
		playNoise(woofFile);
	}

	void playMeow() {
		playNoise(meowFile);
	}

	void playLlama() {
		playNoise(llamaFile);
	}

	String quackFile = "sound/quack.wav";
	String mooFile = "sound/moo.wav";
	String woofFile = "sound/woof.wav";
	String meowFile = "sound/meow.wav";
	String llamaFile = "sound/llama.wav";

	/* Ignore this stuff */

	public void playNoise(String soundFile) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			Thread.sleep(3400);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new AnimalFarm();
	}

}
