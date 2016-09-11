package org.gkjava.rest.messagner.database;

import java.util.HashMap;
import java.util.Map;

import org.gkjava.rest.messagner.model.Message;
import org.gkjava.rest.messagner.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	
	private static Map<Long, Profile> profile = new HashMap<Long, Profile>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<Long, Profile> getProfile() {
		return profile;
	}
}
