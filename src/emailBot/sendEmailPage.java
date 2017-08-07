package emailBot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class sendEmailPage extends JFrame {

	private static String emailSignIn = "";
	private static String passwordSignIn = "";
	private static String url = "https://www.google.com";
	private static Scanner console = new Scanner(System.in);
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
		send_email_from_console_button.setActionCommand("send_email_from_file");
		send_email_from_console_button.addActionListener(new ButtonClickListener());
		
		
		pack();
		setSize(300, 300);
		p.add(send_email_from_file_button);
		p.add(re_send_button);
		p.add(send_email_from_console_button);
		add(p);
		
		setVisible(true);
		
	}
	
	class ButtonClickListener extends JFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if(command.equals("")){
				
			} else if (command.equals("")){
				
			} else {
				dispose();
				new inputPageForConsoleEmail();
			}
		}

	}
}
