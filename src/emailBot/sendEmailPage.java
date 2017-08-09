package emailBot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class sendEmailPage extends JFrame {

	private static String emailSignIn = "reinhard.bryce.21@gmail.com";
	private static String passwordSignIn = "Bleach12";
	private static String to = "reinhard.bryce.21@gmail.com";
	private static String subject = "Testy";

	File f = new File("oldMessages.txt");

	public sendEmailPage() {
		super("Choose Email Type");

		Panel p = new Panel();
		p.setLayout(new GridLayout(4, 1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Button re_send_button = new Button();
		re_send_button.setLabel("Re-send an Email");
		re_send_button.setActionCommand("re_send_button");
		re_send_button.addActionListener(new ButtonClickListener());

		Button send_email_from_file_button = new Button();
		send_email_from_file_button.setLabel("Send Email from File");
		send_email_from_file_button.setActionCommand("send_email_from_file");
		send_email_from_file_button.addActionListener(new ButtonClickListener());

		Button send_email_from_console_button = new Button("Send email from Console");
		send_email_from_console_button.setActionCommand("send_email_from_console");
		send_email_from_console_button.addActionListener(new ButtonClickListener());

		pack();
		setSize(300, 300);
		p.add(send_email_from_file_button);
		p.add(re_send_button);
		p.add(send_email_from_console_button);
		add(p);
		setVisible(true);

	}

	/*
	 * Button Listener class that are tied to the buttons made above. Depending
	 * on which command is sent from the buttons (see setActionCommand above) it
	 * can do different things.
	 */
	class ButtonClickListener extends JFrame implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("send_email_from_file")) {
				dispose();
				try {
					bot.sendGmailFromFile(emailSignIn, passwordSignIn, to, subject);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if (command.equals("re_send_button")) {
				//
			} else if (command.equals("send_email_from_console")) {
				dispose();
				new inputPageForConsoleEmail();
			}
		}

	}
}
