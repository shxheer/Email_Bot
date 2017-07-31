package emailBot;

import java.util.ArrayList;

public class messageList {

	private static ArrayList<Message> messages = new ArrayList<>();

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

	public static Message findMessage(int id) {
		return null;
	}


}
