package za.co.invoketech.store.application.config;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import za.co.invoketech.store.application.factory.internal.FactoryModule;
import za.co.invoketech.store.application.util.Constants;
import za.co.invoketech.store.persistence.internal.PersistenceModule;
import za.co.invoketech.store.service.internal.ServiceModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class Goose {

	public static Injector getInjector() {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();   
        return (Injector) servletContext.getAttribute(Injector.class.getName()); 
	}
	
	public static Injector getInjectorForTesting() {
		Injector injector = Guice.createInjector(
				new ServiceModule(),
				new FactoryModule(), 
				new PersistenceModule(), 
				new JpaPersistModule(Constants.PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		return injector;
	}
	
	public static void guicify(Object object) {
		getInjector().injectMembers(object);
	}
}
