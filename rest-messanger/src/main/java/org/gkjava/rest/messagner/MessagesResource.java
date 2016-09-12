package org.gkjava.rest.messagner;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gkjava.rest.messagner.model.Message;
import org.gkjava.rest.messagner.service.MessagesService;
import org.gkjava.rest.messagner.service.impl.MessagesServiceImpl;

@Path("/messages")
public class MessagesResource {

	/**
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		MessagesService messagesService = new MessagesServiceImpl();
		List<Message> messageList = messagesService.getAllMessages();
		return messageList;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public List<Message> getMessages(@PathParam("messageId") long messageId) {
		MessagesService messagesService = new MessagesServiceImpl();
		List<Message> messageList = messagesService.getMessage(messageId);
		return messageList;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message postMessage(Message message) {
		MessagesService messagesService = new MessagesServiceImpl();
		return messagesService.addMessage(message);

	}
}
