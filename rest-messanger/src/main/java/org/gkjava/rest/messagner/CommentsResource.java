package org.gkjava.rest.messagner;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gkjava.rest.messagner.model.Comment;
import org.gkjava.rest.messagner.service.CommentsService;
import org.gkjava.rest.messagner.service.impl.CommentsServiceImpl;

@Path("/comments")
public class CommentsResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getComments() {
		CommentsService commentsService = new CommentsServiceImpl();
		List<Comment> commentList = commentsService.getAllComments();
		return commentList;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{commentId}")
	public List<Comment> getComments(@PathParam("commentId") long commentId) {
		CommentsService commentsService = new CommentsServiceImpl();
		List<Comment> commentList = commentsService.getComment(commentId);
		return commentList;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{commentId}")
	public List<Comment> putComments(@PathParam("commentId") long commentId, Comment comment) {
		CommentsService commentsService = new CommentsServiceImpl();
		List<Comment> commentList = commentsService.getComment(commentId);
		return commentList;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment postComment(Comment comment) {
		CommentsService commentsService = new CommentsServiceImpl();
		return commentsService.addComment(comment);

	}
}
