package za.co.invoketech.store.presentation.support;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.component.password.Password;

@FacesValidator("confirmPasswordValidator")
public class ConfirmPasswordValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Password password = (Password) component.getParent().findComponent("password");
		
		String passwordString = (String)password.getValue();
		String confirmPasswordString = (String)value;
		
		if(!passwordString.equals(confirmPasswordString)) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Passwords do not match."));
		}		
	}
}
