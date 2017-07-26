package emailBot;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Message {
	
	private static String subject = "Bot Message"; 
	private static String header = "Hi, ";
	private static String content = "Hello!";
	//TODO Get basic file set up
	private static String footer = "Love, Bryce";
	private static int count = 0;
	public int id = 0;
	
	final private static String botNote = "I'm a bot!";
	
	public Message(String subject, String header, String content, String footer){
		count++;
		id=count;
		this.header = header;
		this.subject = subject;
		this.content = content;
		this.footer = footer;
	}
	
	
	public static void setHeader(String inHeader){
		header = inHeader;
	}
	
	public static String getHeader(){
		return header;
	}
	
	public static void setFooter(String inFooter){
		footer = inFooter;
	}
	
	public static String getFooter(){
		return footer;
	}
	
	public static void setSubject(String inSubject){
		subject= inSubject;
	}
	
	public static String getSubject(){
		return subject;
	}
	
	public String toString(){
		return "Subject: "+subject + " Header: "+header+" Content: "+content+" Footer: "+footer;
		
	}
	
	
}
