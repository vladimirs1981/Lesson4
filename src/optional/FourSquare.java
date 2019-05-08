package optional;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class FourSquare {

	Robot squary = new Robot("mini");

	void go() {

		squary.setSpeed(10);

		squary.setPenWidth(5);

		for (int i = 0; i < 4; i++) {

			squary.setRandomPenColor();

			drawSquare();

			squary.turn(90);
		}

	}

	void drawSquare() {
		squary.penDown();
		for (int i = 0; i < 4; i++) {

			squary.turn(90);
			squary.move(70);
		}

	}

	public static void main(String[] args) {
		new FourSquare().go();
	}

}
