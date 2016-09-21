package org.gkjava.rest.messagner.service;

import java.util.List;

import org.gkjava.rest.messagner.model.Comment;



public interface CommentsService {

	/**
	 * This method is used to get the all comments
	 * @return {@link Comment}
	 */
	List<Comment> getAllComments();

	/**
	 * This method is used to get the specific comment on post
	 * @param commentId
	 * @return
	 */
	List<Comment> getComment(long commentId);
	
	/**
	 * This method is used to add the comment 
	 * @param comment
	 * @return
	 */
	Comment addComment(Comment comment);
	
	/**
	 * This method is used to remove the comment
	 * @param commentId
	 * @return
	 */
	Comment removeComment(long commentId);
	
	/**
	 * This method is used to update the comments 
	 * @param comment
	 * @return
	 */
	Comment updateComment(Comment comment);
}
