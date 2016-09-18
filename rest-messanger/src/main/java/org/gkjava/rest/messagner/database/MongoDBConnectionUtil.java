package org.gkjava.rest.messagner.database;

import java.net.UnknownHostException;

import org.gkjava.rest.messagner.mongodb.MongoDBConnection;

public class MongoDBConnectionUtil {

	public static MongoDBConnection mongoDBConnection = null;

	public static MongoDBConnection getConnection() {
		try {
			mongoDBConnection = new MongoDBConnection();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return mongoDBConnection;
	}
}
