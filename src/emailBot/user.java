package emailBot;

import java.awt.*;
import java.awt.FileDialog;
import java.awt.Frame;
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
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import Pages.GoogleHomePage;

public class user {

	private static String emailSignIn = "";
	private static String passwordSignIn = "";
	private static String url = "https://www.google.com";
	private static Scanner console = new Scanner(System.in);
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

		File f = new File("oldMessages.txt");
		FileWriter writer = new FileWriter(f, true);
		BufferedWriter out = new BufferedWriter(writer);
		PrintWriter pr = new PrintWriter(out);
	
	}
	
	public static void clearMessageFile() throws FileNotFoundException {
		PrintWriter p2 = new PrintWriter("oldMessages.txt");
		p2.close();
	}
}

class ButtonClickListener extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
