package ro.agitman.guice;

import javax.servlet.http.HttpServletRequest;

import org.apache.click.ClickServlet;
import org.apache.click.Page;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
public class MyClickServlet extends ClickServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4629027170382528990L;

	@Inject
	private Injector injector;

	@Override
	protected Page newPageInstance(String path, Class<? extends Page> pageClass, HttpServletRequest request)
			throws Exception {

		Page page = super.newPageInstance(path, pageClass, request);
		injector.injectMembers(page);
		return page;
	}
}
