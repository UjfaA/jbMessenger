package ujfaA.jbMessenger.database;

import java.util.HashMap;
import java.util.Map;

import ujfaA.jbMessenger.model.Message;
import ujfaA.jbMessenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	static {
		messages.put(1L, new Message(1L, "Hello World", "Koshuk"));
		messages.put(2L, new Message(2L, "Hello Jersey", "Koshuk"));
	}
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}