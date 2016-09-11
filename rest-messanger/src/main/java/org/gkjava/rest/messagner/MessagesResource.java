package org.gkjava.rest.messagner;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gkjava.rest.messagner.model.Message;
import org.gkjava.rest.messagner.service.MessagesService;
import org.gkjava.rest.messagner.service.impl.MessagesServiceImpl;

@Path("messages")
public class MessagesResource {

	/**
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
	MessagesService messagesService = new MessagesServiceImpl();
		List<Message> messageList = messagesService.getAllMessages();
		return messageList;
		
	}
}
