package emailBot;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Message {
	private String emailFrom = "";
	private String emailFromPassword = "";
	private String recipient = "";
	private String subject = "";
	private String message = "";
	private static int count = 0;

	public Message(String emailFrom, String emailFromPassword, String recipient, String subject, String message) {
		count++;
		this.emailFrom = emailFrom;
		this.emailFromPassword = emailFromPassword;
		this.recipient = recipient;
		this.subject = subject;
		this.message = message;
	}

	public String getEmailFromPassword() {
		return emailFromPassword;
	}

	public void setEmailFromPassword(String emailFromPassword) {
		this.emailFromPassword = emailFromPassword;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString(){
		return ("emailFrom: "+ emailFrom + " Recipient: "+ recipient + " Subject: "+ subject + " Message: "+message);
	}

}
