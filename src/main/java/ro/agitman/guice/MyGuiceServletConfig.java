package ro.agitman.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * 
 * @author agitman
 */
public class MyGuiceServletConfig extends GuiceServletContextListener {

	private ServletContext context;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		context = servletContextEvent.getServletContext();
		super.contextInitialized(servletContextEvent);
	}

	protected Injector getInjector() {
		return Guice.createInjector(new MyServletModule(), new MyShiroWebModule(this.context));
	}
}
