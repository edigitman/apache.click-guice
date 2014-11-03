package ro.agitman.guice;

import javax.servlet.ServletContext;

import org.apache.shiro.config.Ini;
import org.apache.shiro.guice.web.ShiroWebModule;
import org.apache.shiro.realm.text.IniRealm;

import ro.agitman.security.MongoRealm;

import com.google.inject.Provides;
import com.google.inject.name.Names;

public class MyShiroWebModule extends ShiroWebModule {

	public MyShiroWebModule(ServletContext servletContext) {
		super(servletContext);
	}

	@Override
	protected void configureShiroWeb() {
		bindConstant().annotatedWith(Names.named("shiro.loginUrl")).to("/login.htm");
		bindConstant().annotatedWith(Names.named("shiro.successUrl")).to("/register.htm");
		bindConstant().annotatedWith(Names.named("shiro.redirectUrl")).to("/login.htm");

		bindRealm().to(MongoRealm.class).asEagerSingleton();

		try {
			bindRealm().toConstructor(IniRealm.class.getConstructor(Ini.class));
		} catch (NoSuchMethodException e) {
			addError(e);
		}

		addFilterChain("/logout", LOGOUT);
//		addFilterChain("/register.htm", AUTHC);
//		addFilterChain("/login.htm", AUTHC);
	}

	@Provides
	Ini loadShiroIni() {
		return Ini.fromResourcePath("classpath:shiro.ini");
	}
}
