package emailBot;

import java.util.ArrayList;

import Pages.GoogleHomePage;

public class user {
	
	private static String emailSignIn = "reinhard.bryce.21@gmail.com";
	private static String passwordSignIn = "Bleach12";
	private static String url = "https://www.google.com";
	
	
	public static void main(String[] args) throws InterruptedException{
		bot b = new bot();
		b.sendGmailFromFile(emailSignIn, passwordSignIn, null);
	}
	
}
