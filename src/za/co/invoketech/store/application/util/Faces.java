package za.co.invoketech.store.application.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Faces {
	
	public static void showErrorMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  detail);  
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
