package za.co.invoketech.store.application.exception;

public class CustomerNotLinkedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CustomerNotLinkedException() {
		super("account does not have a customer linked to it");
	}
	
	public CustomerNotLinkedException(String message) {
		super(message);
	}
}
