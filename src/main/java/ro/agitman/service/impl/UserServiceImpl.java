package ro.agitman.service.impl;

import com.google.inject.Inject;
import ro.agitman.model.MongoProvider;
import ro.agitman.service.UserService;

public class UserServiceImpl implements UserService {

    @Inject
    private MongoProvider datastore;

	@Override
	public String getName() {
		return "user name";
	}

}
