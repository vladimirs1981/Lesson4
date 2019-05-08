package exercises;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class ObedientRobot {
	Robot ORobot = new Robot("mini");

	private void drawCircle() {
		ORobot.penDown();
		ORobot.setSpeed(10);
		for (int i = 0; i < 360; i++) {
			ORobot.turn(1);
			ORobot.move(1);
		}
	}

	private void drawSqare() {
		ORobot.penDown();
		ORobot.setSpeed(10);
		for (int i = 0; i < 4; i++) {
			ORobot.move(90);
			ORobot.turn(90);
		}
	}

	private void drawTriangle() {
		ORobot.penDown();
		ORobot.setSpeed(10);
		for (int i = 0; i < 3; i++) {
			ORobot.move(150);
			ORobot.turn(120);
		}

	}


	public static void main(String[] args) {
		int shape = JOptionPane.showOptionDialog(null, "Which shape would you like me to draw?", "Obedient Robot", 0,
				JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Circle", "Square", "Triangle" }, null);
		if (shape == 1) {
			new ObedientRobot().drawSqare();
		} else if (shape == 2) {
			new ObedientRobot().drawTriangle();
		} else if (shape == 0) {
			new ObedientRobot().drawCircle();
		}

	}

}
