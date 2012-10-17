package za.co.invoketech.store.application.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;

public class GuiceServletConfig extends GuiceServletContextListener {

	public static final String PERSISTENCE_UNIT = "storeJpaUnit";
	
	@Override
	protected Injector getInjector() {
		Injector injector = Guice.createInjector(new JpaPersistModule(PERSISTENCE_UNIT), new GuiceServletModule());
		injector.getInstance(ApplicationInitializer.class);
		return injector;
	}

}
