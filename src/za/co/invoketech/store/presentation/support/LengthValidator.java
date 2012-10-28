package za.co.invoketech.store.presentation.support;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("lengthValidator")
public class LengthValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Map<String, Object> attributes = component.getAttributes();
		String input = (String)value;
		
		String label = "Input";
		int minumum = -1;
		int maximum = -1;
		
		if(attributes.get("label") != null) {
			label = attributes.get("label").toString();
		}
		
		if(attributes.get("minimum") != null) {
			minumum = Integer.parseInt(attributes.get("minimum").toString());
		}
		
		if(attributes.get("maximum") != null) {
			maximum = Integer.parseInt(attributes.get("maximum").toString());
		}
		
		if(minumum != -1 && input.length() < minumum) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", label + " is too short."));
		}
		
		if(maximum != -1 && input.length() > maximum) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", label + " is too long."));
		}
	}
}
