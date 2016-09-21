package org.gkjava.rest.messagner.service;

import java.util.List;

import org.gkjava.rest.messagner.model.Profile;

public interface ProfilesService {

	List<Profile> getAllProfiles();

	List<Profile> getProfile(long profileId);
	
	Profile addProfile(Profile profile);
	
	Profile removeProfile(long profileId);
	
	Profile updateProfile(Profile profile);
}
