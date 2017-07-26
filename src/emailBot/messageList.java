package emailBot;

import java.util.ArrayList;

public class messageList {

	private static ArrayList<Message> messages = new ArrayList<>();
	private static String to = "";
	private static String from = "";
	private static String pass = "";

	public messageList(String to, String from, String pass) {
		this.to = to;
		this.from = from;
		this.pass = pass;
	}

	public static void addMessage(Message m) {
		messages.add(m);
	}

	public static void printMessages() {
		for (Message m : messages) {
			System.out.println(m);
		}
	}

	public static void deleteMessage(int index) {
		messages.remove(index);
	}

	// O(n) complexity
	public static Message findMessage(int id) {
		for (Message m : messages) {
			if (m.id == id) {
				return m;
			}
		}
		return null;
	}


}
