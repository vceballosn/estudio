package com.estudio;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

/** * Java MongoDB : Convert JSON data to DBObject and insert it to dab * */
public class JsonApp {
	public static void main(String[] args) {
		try {
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("dbname");
			DBCollection collection = db.getCollection("dummyColl");
			// convert JSON to DBObject directly
			DBObject obj = (DBObject) JSON.parse("sample_json");
			collection.insert(obj);
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}