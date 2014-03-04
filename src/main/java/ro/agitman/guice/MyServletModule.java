package ro.agitman.guice;

import ro.agitman.service.UserService;
import ro.agitman.service.impl.UserServiceImpl;

import com.google.inject.servlet.ServletModule;

public class MyServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		super.configureServlets();
		serve("*.htm").with(MyClickServlet.class);
		bind(UserService.class).to(UserServiceImpl.class);
	}

}
