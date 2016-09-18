package org.gkjava.rest.messagner.service.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.gkjava.rest.messagner.database.MessageDaoImpl;
import org.gkjava.rest.messagner.model.Message;
import org.gkjava.rest.messagner.service.MessagesService;

public class MessagesServiceImpl implements MessagesService {
	
	MessageDaoImpl messageDao =new MessageDaoImpl();
	
	@Override
	public List<Message> getAllMessages() {
		return new ArrayList<Message> ( messageDao.getMessages().values());
	}

	@Override
	public List<Message> getMessage(long messageId) {
		return new ArrayList<Message> ( messageDao.getMessages(messageId).values());
	
	}

	@Override
	public Message addMessage(Message message) {
		long id = getAllMessages().size() + 1;
		message.setId(id);
		messageDao.addMessages(message);
		return message;
	}

	@Override
	public Message removeMessage(long messageId) {
		/*return messages.remove(messageId);*/
		return null;
	}

	@Override
	public Message updateMessage(Message message) {
	/*	if (message.getId() <= 0) {
			return null;
		}
		messageDao.u
		return messages.put(message.getId(), message);*/
		return null;
	}

}
