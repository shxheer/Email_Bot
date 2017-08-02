package emailBot;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Pages.GoogleHomePage;

public class user {

	private static String emailSignIn = "";
	private static String passwordSignIn = "";
	private static String url = "https://www.google.com";
	private static String message = "";
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException, IOException {
		File f = new File("/Users/breinhard/Desktop/Eclipse Workspace/emailBot/src/Logs/oldMessages.txt");
		Scanner console = new Scanner(System.in);
		FileWriter writer = new FileWriter(f);
		BufferedWriter out = new BufferedWriter(writer);
		
		bot b = new bot();
		
		System.out.println("Do you want to send a message? (Y,N): ");
		String ans = console.next();
		if (ans.equalsIgnoreCase("N")) {
			System.out.println("Exiting.");
			System.exit(1);
		} else {
			console.nextLine();
			System.out.println("Sending email address: ");
			emailSignIn = console.nextLine();
			System.out.println("Sending email address password: ");
			passwordSignIn = console.nextLine();
		}
		
		System.out.println("Do you want to send a pre-existing message? (Y,N): ");
		String ans2 = console.next();

		if (ans2.equalsIgnoreCase("Y")) {
			System.out.println("Hit print messages");
			messageList.printMessages();
			//add choosing capability
		}
		System.out.println("Send email with input from console? (Y,N): ");
		String ans3 = console.next();

		if (ans3.equalsIgnoreCase("Y")) {
			System.out.println("Input message text: ");
			console.nextLine();
			String message = console.nextLine();
			System.out.println("Input message recipient: ");
			String to = console.nextLine(); 
			//add validation
			System.out.println("Input message subject: ");
			String subject = console.nextLine();
			Message m = new Message(emailSignIn, passwordSignIn, to, subject, message);
			if(message != null){
				System.out.println("Do you want to save this message?(Y,N): ");
				String a = console.nextLine();
				if(a.equalsIgnoreCase("Y")){
					System.out.println("Hit add message");
					messageList.addMessage(m);
					out.write(m.toString());
				}
			}
			messageList.addMessage(m);
			messageList.printMessages();
			System.out.println("Is this info correct? (Y,N): ");
		
			String answer = console.next();
			if(answer.equalsIgnoreCase("N")){
				System.out.println("Improper input. Exiting.");
				System.exit(1);
			}
			b.composeGmailFromMessage(emailSignIn, passwordSignIn, message, to, subject);
			
		}
		
	}

}
