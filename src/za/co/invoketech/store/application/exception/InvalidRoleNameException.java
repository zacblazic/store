package za.co.invoketech.store.application.exception;

public class InvalidRoleNameException extends Exception {

	/**
	 * @author Gareth
	 */
	private static final long serialVersionUID = 1L;

	public InvalidRoleNameException() {
		super ("Role name is not valid");
	}

	public InvalidRoleNameException(String message) {
		super (message);
	}
}
