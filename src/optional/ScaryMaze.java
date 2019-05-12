package optional;

import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ScaryMaze extends JPanel implements Runnable, MouseMotionListener {

	BufferedImage maze;
	final int frameWidth = 400;
	final int frameHeight = 300;

	ScaryMaze() throws Exception {

		maze = ImageIO.read(getClass().getResource("maze.png"));

		new Robot().mouseMove(0, 10);

		addMouseMotionListener(this);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		int mouseColor = maze.getRGB(mouseX, mouseY);

		System.out.println(mouseColor);

		int backgroundcolor = -16777216;
		int endcolor = -1237980;

		if (mouseColor == backgroundcolor) {
			scare();
			
		} else if (mouseColor == endcolor) {
			JOptionPane.showMessageDialog(null, "You won!");
			System.exit(0);
		}

	}

	private void scare() {
		System.out.println("BOO!");

		playNoise(screamFile);
//		AudioClip sound = JApplet.newAudioClip(getClass().getResource("scream.wav"));
//
//		// 8. play the scary sound. Hint: type "sound" and then a period.
//		sound.play();
		showScaryImage("image.png");
	}

	private void showScaryImage(String imageName) {
		try {
			maze = ImageIO.read(getClass().getResource(imageName));
		} catch (Exception e) {
			System.err.println("Couldn't find this image: " + imageName);
		}
		repaint();
	}

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new ScaryMaze());
	}

	String screamFile = "sound/scream.wav";

	void playScream() {
		playNoise(screamFile);
	}

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

	@Override
	public void run() {
		JFrame frame = new JFrame("June's Scary Maze");
		frame.add(this);
		setPreferredSize(new Dimension(frameWidth, frameHeight));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(maze, 0, 0, null);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

}
