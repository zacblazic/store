package za.co.invoketech.store.application.exception;

public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CustomerNotFoundException() { 
		super("customer was not found"); 
	}
	
	public CustomerNotFoundException(String message) {
		super(message);
	}
}
