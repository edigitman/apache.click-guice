package ro.agitman.service;

import com.google.inject.ImplementedBy;
import ro.agitman.service.impl.UserServiceImpl;

@ImplementedBy(UserServiceImpl.class)
public interface UserService {

	String getName();

}
