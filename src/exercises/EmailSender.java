package exercises;

import java.util.Random;

import javax.swing.JOptionPane;

public class EmailSender {

	void go() {
		
		String emailaddress = JOptionPane.showInputDialog(null, "Enter email address:");
		setEmailAddress(emailaddress);
		String message = JOptionPane.showInputDialog(null, "Enter message");
		if (send(message)) {
			JOptionPane.showMessageDialog(null, "Message sent");
		} else {
			JOptionPane.showMessageDialog(null, "Message not sent");
		}
	}

	
	boolean send(String greeting) {
		if (this.emailAddress.isBlank()) {
			System.err.println("You did not provide a recipient for the email!");
			return false;
		}
		return new Random().nextBoolean();

	}

	private String emailAddress = "";

	void setEmailAddress(String email) {
		this.emailAddress = email;
	}

	public static void main(String[] args) {
		new EmailSender().go();
	}
}
