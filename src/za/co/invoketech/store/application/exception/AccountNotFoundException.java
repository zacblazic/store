package za.co.invoketech.store.application.exception;

public class AccountNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException()
	{
		super ("Account was not found");
	}
	
	public AccountNotFoundException(String message)
	{
		super (message);
	}
}
