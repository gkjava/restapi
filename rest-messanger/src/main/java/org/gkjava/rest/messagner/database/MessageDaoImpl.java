package org.gkjava.rest.messagner.database;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.component.mongodb.converters.MongoDbBasicConverters;
import org.gkjava.rest.messagner.model.Message;
import org.gkjava.rest.messagner.model.Profile;
import org.gkjava.rest.messagner.mongodb.MongoDBConnection;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class MessageDaoImpl {
	
	private static final String collectionName = "Messages";
	
	private static final String dbName = "social-network";

	/**
	 * This method is used to get all the message's from the mongo db database
	 * @return
	 * @throws UnknownHostException
	 */
	public Map<Long, Message> getMessages() {
		Map<Long, Message> messages = new HashMap<Long, Message>();
		MongoDBConnection mongoDBConnection = null;
		try {
			mongoDBConnection = new MongoDBConnection();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBCursor cursor = mongoDBConnection.findDocument(dbName,
				collectionName);
		while (cursor.hasNext()) {
			BasicDBObject dbObject = (BasicDBObject) cursor.next();
			System.out.println(dbObject);
			if (null != dbObject) {
				long id = dbObject.getInt("id");
				String message = dbObject.getString("message");
				String author = dbObject.getString("author");
				// TODO: Need to fix
				Date created = null; /* new Date(dbObject.getString("created")); */
				messages.put(id, new Message(id, message, created, author));
			}
		}
		return messages;
	}
	
	/**
	 * This method is used to get all the message's from the mongo db database
	 * @return
	 * @throws UnknownHostException
	 */
	public Map<Long, Message> getMessages(long messageId) {
		Map<Long, Message> messages = new HashMap<Long, Message>();
		MongoDBConnection mongoDBConnection = null;
		try {
			mongoDBConnection = new MongoDBConnection();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.put("id", messageId);
		DBCursor cursor = mongoDBConnection.findDocument(dbName,
				collectionName, basicDBObject);
		while (cursor.hasNext()) {
			BasicDBObject dbObject = (BasicDBObject) cursor.next();
			System.out.println(dbObject);
			if (null != dbObject) {
				long id = dbObject.getInt("id");
				String message = dbObject.getString("message");
				String author = dbObject.getString("author");
				// TODO: Need to fix
				Date created = null; /* new Date(dbObject.getString("created")); */
				messages.put(id, new Message(id, message, created, author));
			}
		}
		return messages;
	}
	
	
	public WriteResult addMessages(Message message) {
		Map<Long, Message> messages = new HashMap<Long, Message>();
		MongoDBConnection mongoDBConnection = null;
		try {
			mongoDBConnection = new MongoDBConnection();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBObject basicDBObject = new BasicDBObject();
		basicDBObject = MongoDbBasicConverters.fromAnyObjectToDBObject(message);
		basicDBObject.put("Messages", message);
		return mongoDBConnection.saveDocument(dbName, collectionName,(BasicDBObject) basicDBObject);
		
	}
	
	public static void main(String[] args) {
		MessageDaoImpl dao = new MessageDaoImpl();
		dao.addMessages(new Message(5L, "Sample", "Gaurav"));
	}
}
