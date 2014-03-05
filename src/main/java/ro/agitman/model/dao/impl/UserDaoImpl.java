package ro.agitman.model.dao.impl;

import ro.agitman.model.MongoProvider;
import ro.agitman.model.dao.UserDao;

import com.google.inject.Inject;
import com.mongodb.BasicDBObject;

public class UserDaoImpl implements UserDao {

	@Inject
	private MongoProvider datastore;

	@Override
	public void execute() {
		datastore.get().save(new BasicDBObject("123", "value"));
	}
}
