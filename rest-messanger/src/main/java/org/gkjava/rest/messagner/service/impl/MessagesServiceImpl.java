package org.gkjava.rest.messagner.service.impl;

import java.util.List;

import org.gkjava.rest.messagner.database.DatabaseClass;
import org.gkjava.rest.messagner.model.Message;
import org.gkjava.rest.messagner.service.MessagesService;

public class MessagesServiceImpl implements MessagesService {

	private static DatabaseClass messageDB = new DatabaseClass();
	@Override
	public List<Message> getAllMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message getMessage(long messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message addMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message removeMessage(long messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message updateMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

}
