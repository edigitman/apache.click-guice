package ro.agitman.guice;

import ro.agitman.model.dao.UserDao;
import ro.agitman.model.dao.impl.UserDaoImpl;
import ro.agitman.service.UserService;
import ro.agitman.service.impl.UserServiceImpl;

import com.google.inject.servlet.ServletModule;

public class MyServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		super.configureServlets();

		// mapped custom click servlet
		serve("*.htm").with(MyClickServlet.class);

		// mapped services
		bind(UserService.class).to(UserServiceImpl.class);

		// mapped dao
		bind(UserDao.class).to(UserDaoImpl.class);
	}

}
