package za.co.invoketech.store.application.config;

import com.google.inject.servlet.ServletModule;

public class GuiceServletModule extends ServletModule {
	
	@Override
	protected void configureServlets() {
		serve("*.jsf").with(GuiceFacesServlet.class);
		serve("*.faces").with(GuiceFacesServlet.class);
		serve("*.xhtml").with(GuiceFacesServlet.class);
	}
}
