package ro.agitman.model.dao.impl;

import javax.annotation.PostConstruct;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import ro.agitman.model.dao.UserDao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.mongodb.BasicDBObject;

public class UserDaoImpl implements UserDao {

	@Inject
	private Provider<Jongo> jongoProvider;
	private MongoCollection coll;

	@PostConstruct
	public void init() {
		coll = jongoProvider.get().getCollection("user");
	}

	@Override
	public void execute() {
		coll.insert(new BasicDBObject("123", "value"));
	}
}
