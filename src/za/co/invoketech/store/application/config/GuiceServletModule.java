package za.co.invoketech.store.application.config;

import za.co.invoketech.store.persistence.internal.PersistenceModule;
import za.co.invoketech.store.service.account.internal.AccountRoleModule;
import za.co.invoketech.store.service.file.internal.FileModule;

import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

public class GuiceServletModule extends ServletModule {
	
	public static final String PERSISTENCE_UNIT = "storeJpaUnit";
	
	@Override
	protected void configureServlets() {
		install(new JpaPersistModule(PERSISTENCE_UNIT));
		install(new PersistenceModule());
		install(new FileModule());
		install(new AccountRoleModule());
		
		filter("/*").through(PersistFilter.class);
		filter("/*").through(GuiceFileUploadFilter.class);
		
		serve("*.jsf").with(GuiceFacesServlet.class);
		serve("*.faces").with(GuiceFacesServlet.class);
		serve("*.xhtml").with(GuiceFacesServlet.class);
	}
}
