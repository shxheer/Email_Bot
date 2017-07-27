package emailBot;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Pages.GoogleHomePage;

public class user {

	private static String emailSignIn = "reinhard.bryce.21@gmail.com";
	private static String passwordSignIn = "Bleach12";
	private static String url = "https://www.google.com";
	private static String message = "";

	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner console = new Scanner(System.in);
		bot b = new bot();
		System.out.println("Do you want to send a message? (Y,N): ");
		String ans = console.next();
		if (ans.equalsIgnoreCase("n")) {
			System.exit(1);
		}

		System.out.println("Do you want to send a pre-existing message? (Y,N): ");
		String ans2 = console.next();

		if (ans2.equalsIgnoreCase("Y")) {
			//
			// list all available messages here and pick one.
			// composeEmailFromMessage();
			// set message to selected message, pass it to method
			//
		}
		System.out.println("Send email with input from console? (Y,N): ");
		String ans3 = console.next();

		if (ans3.equalsIgnoreCase("Y")) {
			System.out.println("Input text: ");
			console.nextLine();
			String input = console.nextLine();
			System.out.println(input);
			b.composeEmailFromMessage(emailSignIn, passwordSignIn, input);

		}
	}

}
