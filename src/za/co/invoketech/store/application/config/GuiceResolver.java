package za.co.invoketech.store.application.config;

import javax.el.BeanELResolver;
import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import com.google.inject.Injector;

public class GuiceResolver extends BeanELResolver {

	@Override
	public Object getValue(ELContext context, Object base, Object property) {
		
		System.out.println("GuiceResolver Starting");
		
		Object resolved = super.getValue(context, base, property);
		
		if(resolved != null) {
			
			System.out.println("Primary Resolving Done");
			
			FacesContext facesContext = (FacesContext)context.getContext(FacesContext.class);
			ServletContext servletContext = (ServletContext)facesContext.getExternalContext().getContext();   
	        Injector injector = (Injector) servletContext.getAttribute(Injector.class.getName());
	        
	        System.out.println("Getting the Injector");
	        
	        if(injector != null) {
	        	injector.injectMembers(resolved);
	        	
	        	System.out.println("Injection Performed");
	        }
		}
		
		System.out.println("GuiceResolver Done");
		
		return resolved;
	}
}
