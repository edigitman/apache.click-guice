package ro.agitman.guice;

import org.apache.shiro.guice.web.GuiceShiroFilter;
import org.apache.shiro.guice.web.ShiroWebModule;

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
		//bind(UserService.class).to(UserServiceImpl.class);

		ShiroWebModule.bindGuiceFilter(binder());

		filter("/*").through(GuiceShiroFilter.class);
	}
}
