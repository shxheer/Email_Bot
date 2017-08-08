package emailBot;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class loginPage extends JFrame implements ActionListener{
	private static String emailSignIn = "";
	private static String passwordSignIn = "";
	
	private static TextField sendingEmailTextField;
	private static TextField sendingEmailPassowrdTextField;
	
	public loginPage(){
		super("Choose Email Type");
		
		Panel p = new Panel();
		p.setLayout(new GridLayout(5, 1));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Label sendingEmailLabel = new Label("Email: ");
		sendingEmailTextField = new TextField(25);
		
		Label sendingEmailPasswordLabel = new Label("Password: ");
		sendingEmailPassowrdTextField = new TextField(20);
		
		Button submitButton = new Button();
		submitButton.setLabel("Submit");
		submitButton.setActionCommand("submitButton");
		submitButton.addActionListener((ActionListener) this);
		
		p.add(sendingEmailLabel);
		p.add(sendingEmailTextField);
		p.add(sendingEmailPasswordLabel);
		p.add(sendingEmailPassowrdTextField);
		p.add(submitButton);
		pack();
		setSize(300, 300);
		add(p);
		setVisible(true);
	}
	
	
	public static String getEmailSignIn() {
		return emailSignIn;
	}
	public static void setEmailSignIn(String emailSignIn) {
		loginPage.emailSignIn = emailSignIn;
	}
	public static String getPasswordSignIn() {
		return passwordSignIn;
	}
	public static void setPasswordSignIn(String passwordSignIn) {
		loginPage.passwordSignIn = passwordSignIn;
	}
	
	private static void setFields() {
		setEmailSignIn(sendingEmailTextField.getText());
		setPasswordSignIn(sendingEmailPassowrdTextField.getText());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equals("submitButton")) {
			loginPage.setFields();
			try {
				bot.signInGoogle(emailSignIn, passwordSignIn);
				dispose();
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
		}
	}
	
}
