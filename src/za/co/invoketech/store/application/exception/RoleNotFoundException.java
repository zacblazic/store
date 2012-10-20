package za.co.invoketech.store.application.exception;

public class RoleNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RoleNotFoundException() {
		super("Specified role does not exist.");
	}
	
	public RoleNotFoundException(String message) {
		super(message);
	}
	
}
