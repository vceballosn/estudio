package estudio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

public class CallJson implements Serializable {

	public static void main(String[] args) throws IOException, JSONException, ParseException {

		System.out.println(valiteDate());     
		if (valiteDate()==0) {
			System.out.println("Drop Collections "+ dropCollection());
			JSONObject json = readJsonFromUrl("https://api.telogis.com/rest/login/vialimpia/vsalinas/vsalinas");
			System.out.println(json.toString());
			System.out.println(json.get("userId"));
			System.out.println(" importacion Json " + importJson(json));	
			System.out.println("Respuesta de la modificacion fecha "+ updateDate());
		}else {

			System.out.println(" id Job "+ searhId("vsalinas"));
		}
		
		
		//System.out.println("Respuesta de la modificacion fecha "+ updateDate());
		//System.out.println("Drop Collections "+ dropCollection());
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public  static String importJson(JSONObject json) {

		String mensaje="";  
		try {

			DB db = getConexionMongoDB().getDB("testdb");
			DBCollection collection = db.getCollection("user");
			// convert JSON to DBObject directly
			DBObject obj = (DBObject) JSON.parse(json.toString());
			collection.insert(obj);
			System.out.println("Done");
			mensaje ="importacion correcta";
		} catch (Exception e) {
			e.printStackTrace();
			mensaje ="error en la importacion";
		}

		return mensaje;			  
	}


	public static int valiteDate() throws ParseException {

		Date dateDb = null;
		DB db = getConexionMongoDB().getDB("testdb");
		DBCollection table = db.getCollection("date");
		/**** Find and display ****/
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("idDate", "1");
		DBCursor cursor = table.find(searchQuery);
		while (cursor.hasNext()) {
			dateDb =(Date)cursor.next().get("date");
		}


		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = dateFormat.parse(dateFormat.format(dateDb));
		Date date = dateFormat.parse(dateFormat.format(new Date()));
		System.out.println(" date2 " +date2);
		System.out.println(" date " +date);
		return date.compareTo(date2) ;  // sin son iguales es cero distinta 1
	}


	public static Mongo getConexionMongoDB() {
		Mongo mongo = null;
		try {
			mongo = new Mongo("localhost", 27017);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error en la Conexion");
		}
		return mongo;
	}

	public static String insertDate() {
		String response ="";
		try {
			DB db = getConexionMongoDB().getDB("testdb");
			DBCollection table = db.getCollection("date");
			BasicDBObject document = new BasicDBObject();
			document.put("idDate", "1");
			document.put("date",sumarFechasDias(new Date(),1));
			table.insert(document);
			response ="insert success";
		}catch (Exception e) {
			e.printStackTrace();
			response = "Error insertDate "; 

		}
		return response; 

	}

	//Sumarle dias a una fecha determinada
	//@param fch La fecha para sumarle los dias
	//@param dias Numero de dias a agregar
	//@return La fecha agregando los dias
	public static Date sumarFechasDias(Date fch, int dias) {
		Calendar cal = new GregorianCalendar();
		cal.setTimeInMillis(fch.getTime());
		cal.add(Calendar.DATE, dias);
		return new Date(cal.getTimeInMillis());
	}


	public static String searhId(String user) {

		String response ="";

		try {
			DB db = getConexionMongoDB().getDB("testdb");
			DBCollection table = db.getCollection("user");
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("username", user);
			DBCursor cursor = table.find(searchQuery);
			while (cursor.hasNext()) {
				response =	cursor.next().get("userId").toString();
			}
		}catch(Exception e) {
			e.printStackTrace();
			response ="Problemas con la consulta searhId ";
		}

		return response;
	}


	public static String updateDate() {
		String response ="";
		try {
			DB db = getConexionMongoDB().getDB("testdb");
			DBCollection table = db.getCollection("date"); 
			BasicDBObject query = new BasicDBObject();
			query.put("idDate", "1");
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("date", sumarFechasDias(new Date(),1));
			//newDocument.put("date", new Date());
			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);
			table.update(query, updateObj);
			response ="update success";
		}catch (Exception e) {
			e.printStackTrace();
			response = "Error updateDate "; 

		}
		return response; 

	}
	
	
	public static String dropCollection() {
		String response ="";
		try {
			DB db = getConexionMongoDB().getDB("testdb");
			System.out.println("existe "+ db.collectionExists("user"));
			    DBCollection table = db.getCollection("user");
			    table.drop();
			response ="dropCollection success";
		}catch (Exception e) {
			e.printStackTrace();
			response = "Error dropCollection "; 

		}
		return response; 

	}

}
