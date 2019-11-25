package ujfaA.jbMessenger.database;

import java.util.HashMap;
import java.util.Map;

import ujfaA.jbMessenger.model.Message;
import ujfaA.jbMessenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	static {
		
		profiles.put("admin", new Profile(1L, "admin", "Super", "Admin"));
		profiles.put("alex", new Profile(2L, "alex", "Aleksandar", "Ujfaluši"));
		profiles.put("ujfa", new Profile(3L, "ujfa", "Alex", "Ujfa"));

		messages.put(1L, new Message(1L, "Hello World", "admin"));
		messages.put(2L, new Message(2L, "Hello Jersey", "admin"));
		messages.get(2L).getCreated().setYear(2000);
	}
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}