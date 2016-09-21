package org.gkjava.rest.messagner.service;

import java.util.List;

import org.gkjava.rest.messagner.model.Like;

public interface LikesService {

	List<Like> getAllLikes();

	List<Like> getLike(long likeId);
	
	Like addLike(Like like);
	
	Like removeLike(long likeId);
	
	Like updateLike(Like like);
}
