package exercises;

import org.jointheleague.graphical.robot.Robot;

public class TriangleShell {

	Robot shelly = new Robot("mini");

	void go() {

		shelly.setSpeed(100);

		int lenght = 50;

		for (int i = 0; i < 60; i++) {

			shelly.setRandomPenColor();

			lenght += 10;

			drawTriangle(lenght);

			shelly.turn(6);

		}
	}

	private void drawTriangle(int length) {
		shelly.penDown();
		for (int i = 0; i < 3; i++) {
			shelly.move(length);
			shelly.turn(120);
		}

	}

	public static void main(String[] args) {
		new TriangleShell().go();
	}
}
