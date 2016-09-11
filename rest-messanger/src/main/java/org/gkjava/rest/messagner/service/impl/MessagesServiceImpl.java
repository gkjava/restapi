package org.gkjava.rest.messagner.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.gkjava.rest.messagner.database.DatabaseClass;
import org.gkjava.rest.messagner.model.Message;
import org.gkjava.rest.messagner.service.MessagesService;

public class MessagesServiceImpl implements MessagesService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessagesServiceImpl() {
		messages.put(1L, new Message(1L, "Hello World!!", "Gaurav"));
		messages.put(2L, new Message(2L, "Hello World!!", "Gaurav"));
		messages.put(3L, new Message(3L, "Hello World!!", "Gaurav"));
	}
	@Override
	public List<Message> getAllMessages() {
		return new ArrayList<Message> ( messages.values());
	}

	@Override
	public Message getMessage(long messageId) {
		return messages.get(messageId);
	
	}

	@Override
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	@Override
	public Message removeMessage(long messageId) {
		return messages.remove(messageId);
	}

	@Override
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		return messages.put(message.getId(), message);
	}

}
