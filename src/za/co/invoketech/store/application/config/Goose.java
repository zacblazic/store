package za.co.invoketech.store.application.config;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import com.google.inject.Injector;

public class Goose {

	public static Injector getInjector() {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();   
        return (Injector) servletContext.getAttribute(Injector.class.getName()); 
	}
}
