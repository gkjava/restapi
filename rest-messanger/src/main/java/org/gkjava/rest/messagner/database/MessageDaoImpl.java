package org.gkjava.rest.messagner.database;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.component.mongodb.converters.MongoDbBasicConverters;
import org.gkjava.rest.messagner.model.Message;
import org.gkjava.rest.messagner.model.Profile;
import org.gkjava.rest.messagner.mongodb.MongoDBConnection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class MessageDaoImpl {

	private static final String collectionName = "Messages";

	private static final String dbName = "social-network";

	MongoDBConnection mongoDBConnection = null;

	/**
	 * This method is used to get all the message's from the mongo db database
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public Map<Long, Message> getMessages() {
		Map<Long, Message> messages = new HashMap<Long, Message>();

		mongoDBConnection = MongoDBConnectionUtil.getConnection();
		DBCursor cursor = mongoDBConnection
				.findDocument(dbName, collectionName);

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
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public Map<Long, Message> getMessages(long messageId) {
		Map<Long, Message> messages = new HashMap<Long, Message>();
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.put("id", messageId);
		DBCursor cursor = mongoDBConnection.findDocument(dbName,
				collectionName, basicDBObject);
		mongoDBConnection = MongoDBConnectionUtil.getConnection();
		while (cursor.hasNext()) {
			BasicDBObject dbObject = (BasicDBObject) cursor.next();
			System.out.println(dbObject);
			if (null != dbObject) {
				long id = dbObject.getInt("id");
				String message = dbObject.getString("message");
				String author = dbObject.getString("author");
				// TODO: Need to fix
				messages.put(id, new Message(id, message, null, author));
			}
		}
		return messages;
	}
	/**
	 * 
	 * @param message
	 * @return
	 */
	public WriteResult addMessages(Message message) {
		Map<Long, Message> messages = new HashMap<Long, Message>();
		DBObject basicDBObject = new BasicDBObject();
		basicDBObject = MongoDbBasicConverters.fromAnyObjectToDBObject(message);
		basicDBObject.put("Messages", message);
		mongoDBConnection = MongoDBConnectionUtil.getConnection();
		return mongoDBConnection.saveDocument(dbName, collectionName,
				(BasicDBObject) basicDBObject);

	}

	public WriteResult updateMessage(long messageId, Message message) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("messageId", messageId);

		DBObject basicDBObject = new BasicDBObject();
		basicDBObject = MongoDbBasicConverters.fromAnyObjectToDBObject(message);
		basicDBObject.put("Messages", message);

		mongoDBConnection = MongoDBConnectionUtil.getConnection();
		return mongoDBConnection.updateDocument(dbName, "Messages",
				basicDBObject, searchQuery);
	}

}
