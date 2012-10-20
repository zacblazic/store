package za.co.invoketech.store.application.exception;

public class NonExistentRoleException extends Exception {

	private static final long serialVersionUID = 1L;

	public NonExistentRoleException() {
		super("Specified role does not exist.");
	}
	
	public NonExistentRoleException(String message) {
		super(message);
	}
	
}
