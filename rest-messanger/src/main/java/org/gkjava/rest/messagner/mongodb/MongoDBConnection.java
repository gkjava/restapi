package org.gkjava.rest.messagner.mongodb;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class MongoDBConnection {

	MongoClient mongoClient = null;

	private static final String HOST = "localhost";

	private static final int PORT = 27017;

	/**
	 * @throws UnknownHostException
	 */
	public MongoDBConnection() throws UnknownHostException {

		mongoClient = new MongoClient(HOST, PORT);
	}

	/**
	 * @param userId
	 * @param pwd
	 */
	public MongoDBConnection(int userId, String pwd) {
		// TODO: Need to be implement
	}

	/**
	 * @param properties
	 */
	public MongoDBConnection(Properties properties) {
		// TODO: Need to be implement
	}

	/**
	 * @return
	 */
	public List<String> getDBList() {
		return mongoClient.getDatabaseNames();
	}

	/**
	 * @param dbName
	 * @return
	 */
	public Set<String> getCollection(String dbName) {
		DB db = mongoClient.getDB(dbName);
		return db.getCollectionNames();
	}

	/**
	 * @param dbName
	 * @param collectionName
	 * @return
	 */
	public DBCollection getCollection(String dbName, String collectionName) {
		DB db = mongoClient.getDB(dbName);
		return db.getCollectionFromString(collectionName);
	}

	/**
	 * This method is used to save the document in particular collection
	 * @param dbName
	 * @param collectionName
	 * @param basicDBObject
	 * @return
	 */
	public WriteResult saveDocument(String dbName, String collectionName,
			BasicDBObject basicDBObject) {
		DB db = mongoClient.getDB(dbName);
		DBCollection dbCollection = db.getCollectionFromString(collectionName);
		return dbCollection.insert(basicDBObject);
	}

	/**
	 * This method is used to update the BasicDBObject object on the basis of search query
	 * @param dbName
	 * @param collectionName
	 * @param newBasicDBObject
	 * @param searchQuery
	 * @return
	 */
	public WriteResult updateDocument(String dbName, String collectionName,
			DBObject newBasicDBObject, DBObject searchQuery) {
		DB db = mongoClient.getDB(dbName);
		DBCollection dbCollection = db.getCollectionFromString(collectionName);
		BasicDBObject updateObj = new BasicDBObject();
		updateObj.put("$set", newBasicDBObject);
		return dbCollection.update(searchQuery, updateObj);
	}

	/**
	 * @param dbName
	 * @param collectionName
	 * @param searchQuery
	 * @return
	 */
	public DBCursor findDocument(String dbName, String collectionName,
			BasicDBObject searchQuery) {
		DB db = mongoClient.getDB(dbName);
		DBCollection dbCollection = db.getCollectionFromString(collectionName);
		return dbCollection.find(searchQuery);
	}
	
	/**
	 * @param dbName
	 * @param collectionName
	 * @param searchQuery
	 * @return
	 */
	public DBCursor findDocument(String dbName, String collectionName) {
		DB db = mongoClient.getDB(dbName);
		DBCollection dbCollection = db.getCollectionFromString(collectionName);
		return dbCollection.find();
	}

	/**
	 * This method is used to remove the document from collection
	 * 
	 * @param dbName
	 *            {@link Sting}
	 * @param collectionName
	 * @param searchQuery
	 * @return
	 */
	public WriteResult deleteDocument(String dbName, String collectionName,
			BasicDBObject searchQuery) {
		DB db = mongoClient.getDB(dbName);
		DBCollection dbCollection = db.getCollectionFromString(collectionName);
		return dbCollection.remove(searchQuery);
	}
}
