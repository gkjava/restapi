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

import org.gkjava.rest.messagner.model.Like;
import org.gkjava.rest.messagner.service.LikesService;
import org.gkjava.rest.messagner.service.impl.LikesServiceImpl;

@Path("/likes")
public class LikesResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Like> getLikes() {
		LikesService likesService = new LikesServiceImpl();
		List<Like> likeList = likesService.getAllLikes();
		return likeList;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{likeId}")
	public List<Like> getLikes(@PathParam("likeId") long likeId) {
		LikesService likesService = new LikesServiceImpl();
		List<Like> likeList = likesService.getLike(likeId);
		return likeList;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{likeId}")
	public List<Like> getLikes(@PathParam("likeId") long likeId, Like like) {
		LikesService likesService = new LikesServiceImpl();
		List<Like> likeList = likesService.getLike(likeId);
		return likeList;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Like postLike(Like like) {
		LikesService likesService = new LikesServiceImpl();
		return likesService.addLike(like);

	}
}
