package ro.agitman.model;

import java.net.UnknownHostException;

import org.jongo.Jongo;

import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Singleton
public class MongoProvider implements Provider<Jongo> {

	private Mongo mongo;
	private Jongo jongo;

	public Jongo get() {
		if (mongo == null || jongo == null) {
			try {
				mongo = new MongoClient("localhost", 27017);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			DB db = mongo.getDB("dbname");
			jongo = new Jongo(db);
		}
		return jongo;
	}
}
