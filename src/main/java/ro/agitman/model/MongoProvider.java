package ro.agitman.model;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Singleton
public class MongoProvider implements Provider<Datastore> {

	private Mongo mongo = null;
	private Morphia morphia = null;
	private Datastore ds = null;

	public Datastore get() {
		if (mongo == null || morphia == null) {
			try {
				mongo = new MongoClient("localhost", 27017);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			morphia = new Morphia();
			morphia.mapPackage("ro.agitman.model.mo");
			ds = morphia.createDatastore(mongo, "social");
		}
		return ds;
	}
}
