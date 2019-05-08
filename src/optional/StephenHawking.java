package optional;

import javax.swing.JOptionPane;

import voce.SpeechSynthesizer;

public class StephenHawking {
	public static void main(String[] args) {

		while (true) {
			String sentence = JOptionPane.showInputDialog(null, "Write a sentence");
			if (sentence.isEmpty()) {
				System.exit(0);
			} else {
				speak(sentence);
			}
		}
	}

	static void speak(String words) {
		SpeechSynthesizer speaker = new SpeechSynthesizer("speaker");
		speaker.synthesize(words);
	}

}
