package org.gkjava.rest.messagner;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gkjava.rest.messagner.model.Profile;
import org.gkjava.rest.messagner.service.ProfilesService;
import org.gkjava.rest.messagner.service.impl.ProfilesServiceImpl;

@Path("/profiles")
public class ProfilesResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles() {
		ProfilesService profilesService = new ProfilesServiceImpl();
		List<Profile> profileList = profilesService.getAllProfiles();
		return profileList;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileId}")
	public List<Profile> getProfiles(@PathParam("profileId") long profileId) {
		ProfilesService profilesService = new ProfilesServiceImpl();
		List<Profile> profileList = profilesService.getProfile(profileId);
		return profileList;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile postProfile(Profile profile) {
		ProfilesService profilesService = new ProfilesServiceImpl();
		return profilesService.addProfile(profile);

	}
}
