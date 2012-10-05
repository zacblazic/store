package za.co.invoketech.store.application.exception;

public class InvalidSupplierPriceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidSupplierPriceException() {
		super("Invalid Supplier Price, Cannot be negative.");
		// TODO Auto-generated constructor stub
	}
	
	
}
