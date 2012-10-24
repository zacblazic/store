package za.co.invoketech.store.application.exception;

public class MaximumAddressesReachedException extends Exception {

	private static final long serialVersionUID = 1L;

	public MaximumAddressesReachedException() {
		super("customer has reached the maximum amount of addresses");
	}
	
	public MaximumAddressesReachedException(String message) {
		super(message);
	}
}
