package emailBot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;

public class inputPageForConsoleEmail extends JFrame implements ActionListener {
	//Info needed to send a message
	private static String emailSignIn = "";
	private static String passwordSignIn = "";
	private static String recipient = "";
	private static String subject = "";
	private static String message = "";

	//TextField fields
	private static TextField sendingEmailTextField;
	private static TextField sendingEmailPassowrdTextField;
	private static TextField recipientTextField;
	private static TextField subjectTextField;
	private static TextField messageTextField;
	

	public inputPageForConsoleEmail() {
		super("Input page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel p = new Panel();
		p.setLayout(new GridLayout(11, 1));
		Label sendingEmailLabel = new Label("Sending Email: ");
		sendingEmailTextField = new TextField(25);

		Label sendingEmailPasswordLabel = new Label("Sending Email Password: ");
		sendingEmailPassowrdTextField = new TextField(20);

		Label recipientLabel = new Label("Recipient email address: ");
		recipientTextField = new TextField(20);

		Label subjectLabel = new Label("Subject of Message: ");
		subjectTextField = new TextField(20);

		Label messageLabel = new Label("Message (200 char limit): ");
		messageTextField = new TextField(200);

		Button submitButton = new Button();
		submitButton.setLabel("Submit");
		submitButton.setActionCommand("submitButton");
		submitButton.addActionListener((ActionListener) this);
		p.add(sendingEmailLabel);
		p.add(sendingEmailTextField);
		p.add(sendingEmailPasswordLabel);
		p.add(sendingEmailPassowrdTextField);
		p.add(recipientLabel);
		p.add(recipientTextField);
		p.add(subjectLabel);
		p.add(subjectTextField);
		p.add(messageLabel);
		p.add(messageTextField);
		p.add(submitButton);
		add(p);
		pack();
		setSize(300, 300);
		setVisible(true);

	}

	public static String getEmailSignIn() {
		return emailSignIn;
	}

	public static void setEmailSignIn(String emailSignIn) {
		inputPageForConsoleEmail.emailSignIn = emailSignIn;
	}

	public static String getPasswordSignIn() {
		return passwordSignIn;
	}

	public static void setPasswordSignIn(String passwordSignIn) {
		inputPageForConsoleEmail.passwordSignIn = passwordSignIn;
	}

	public static String getRecipientAddress() {
		return recipient;
	}

	public static void setRecipientAddress(String recipientAddress) {
		inputPageForConsoleEmail.recipient = recipientAddress;
	}

	private static void setFields() {
		setEmailSignIn(sendingEmailTextField.getText());
		setPasswordSignIn(sendingEmailPassowrdTextField.getText());
		setRecipientAddress(recipientTextField.getText());
		setSubject(subjectTextField.getText());
		setMessage(messageTextField.getText());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equals("submitButton")) {
			inputPageForConsoleEmail.setFields();
			try {
				bot.composeGmailFromMessage(emailSignIn, passwordSignIn, message, recipient, subject);
				dispose();
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
		}
	}

	public static String getSubject() {
		return subject;
	}

	public static void setSubject(String subject) {
		inputPageForConsoleEmail.subject = subject;
	}

	public static String getMessage() {
		return message;
	}

	public static void setMessage(String message) {
		inputPageForConsoleEmail.message = message;
	}

}
