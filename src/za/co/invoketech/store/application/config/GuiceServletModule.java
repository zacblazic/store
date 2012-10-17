package za.co.invoketech.store.application.config;

import za.co.invoketech.store.repository.dao.internal.PersistenceModule;

import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

public class GuiceServletModule extends ServletModule {
	
	public static final String PERSISTENCE_UNIT = "storeJpaUnit";
	
	@Override
	protected void configureServlets() {
		install(new JpaPersistModule(PERSISTENCE_UNIT));
		install(new PersistenceModule());
		
		filter("/*").through(PersistFilter.class);
		
		serve("*.jsf").with(GuiceFacesServlet.class);
		serve("*.faces").with(GuiceFacesServlet.class);
		serve("*.xhtml").with(GuiceFacesServlet.class);
		
		System.out.println("SERVLETMODULE INNITTED");
	}
}
