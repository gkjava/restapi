package org.gkjava.rest.messagner.service;

import java.util.ArrayList;
import java.util.List;

import org.gkjava.rest.messagner.model.Message;

public interface MessagesService {

	List<Message> getAllMessages();

	List<Message> getMessage(long messageId);
	
	Message addMessage(Message message);
	
	Message removeMessage(long messageId);
	
	Message updateMessage(Message message);
}
