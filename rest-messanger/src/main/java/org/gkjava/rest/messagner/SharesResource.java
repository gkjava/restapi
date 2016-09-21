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

import org.gkjava.rest.messagner.model.Share;
import org.gkjava.rest.messagner.service.SharesService;
import org.gkjava.rest.messagner.service.impl.SharesServiceImpl;

@Path("/shares")
public class SharesResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Share> getShares() {
		SharesService sharesService = new SharesServiceImpl();
		List<Share> shareList = sharesService.getAllShares();
		return shareList;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{shareId}")
	public List<Share> getShares(@PathParam("shareId") long shareId) {
		SharesService sharesService = new SharesServiceImpl();
		List<Share> shareList = sharesService.getShare(shareId);
		return shareList;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{shareId}")
	public List<Share> putShares(@PathParam("shareId") long shareId, Share share) {
		SharesService sharesService = new SharesServiceImpl();
		List<Share> shareList = sharesService.getShare(shareId);
		return shareList;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Share postShare(Share share) {
		SharesService sharesService = new SharesServiceImpl();
		return sharesService.addShare(share);

	}
}
