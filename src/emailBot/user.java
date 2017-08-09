package emailBot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFrame;

public class user {
	// Fields
	private static JFrame main;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException, IOException {

		main = new JFrame("Email Bot");
		main.setSize(300, 300);
		main.setLayout(new GridLayout(4, 2));
		main.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		Panel controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		Button loginButton = new Button();
		loginButton.setLabel("Login to Email");
		loginButton.setActionCommand("loginButton");

		Button sendEmailButton = new Button();
		sendEmailButton.setLabel("Send Email");
		sendEmailButton.setActionCommand("sendEmailButton");

		Button cancelButton = new Button();
		cancelButton.setLabel("Cancel");
		cancelButton.setActionCommand("cancelButton");

		loginButton.addActionListener(new ButtonClickListener());
		sendEmailButton.addActionListener(new ButtonClickListener());
		cancelButton.addActionListener(new ButtonClickListener());

		main.add(loginButton, controlPanel);
		main.add(sendEmailButton);
		main.add(cancelButton);
		main.setVisible(true);

		// File f = new File("oldMessages.txt");
		// FileWriter writer = new FileWriter(f, true);
		// BufferedWriter out = new BufferedWriter(writer);
		// PrintWriter pr = new PrintWriter(out);

	}

	public static void clearMessageFile() throws FileNotFoundException {
		PrintWriter p2 = new PrintWriter("oldMessages.txt");
		p2.close();
	}
}

/*
 * Class to define what happens based on which button is clicked.
 */
@SuppressWarnings("serial")
class ButtonClickListener extends JFrame implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("sendEmailButton")) {
			new sendEmailPage();
		} else if (command.equals("loginButton")) {
			new loginPage();
		} else {
			System.out.println("Cancel Button hit. Exiting.");
			System.exit(1);
		}
	}
}
