package ro.agitman.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * 
 * @author agitman
 */
public class MyGuiceServletConfig extends GuiceServletContextListener {

	protected Injector getInjector() {
		return Guice.createInjector(new MyServletModule());
	}

}
