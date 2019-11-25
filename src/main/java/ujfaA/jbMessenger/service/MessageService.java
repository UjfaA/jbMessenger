package ujfaA.jbMessenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import ujfaA.jbMessenger.database.DatabaseClass;
import ujfaA.jbMessenger.model.Message;

public class MessageService {
	
	private static long messagesCreated = DatabaseClass.getMessages().size();
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year)
				messagesForYear.add(message);
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPagineted(int start, int size) {
		
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		start -= 1;
		if (start + size > list.size())
			return new ArrayList<Message>();
		return list.subList(start, start + size);
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		messagesCreated++;
		message.setId(messagesCreated);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0)
			return null;
		messages.replace(message.getId(), message);
		return message;
	}

	public Message removeMessage(Long id) {
		return messages.remove(id);
	}
}
