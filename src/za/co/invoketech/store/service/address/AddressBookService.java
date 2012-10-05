package za.co.invoketech.store.service.address;

import za.co.invoketech.store.application.exception.CustomerNotFoundException;
import za.co.invoketech.store.application.exception.TooManyAddressesException;
import za.co.invoketech.store.model.address.Address;

public interface AddressBookService {

	public void addAddress(Address address, long customerId) throws CustomerNotFoundException, TooManyAddressesException;
	void removeAddress(long addressId, long customerId) throws CustomerNotFoundException;
	void updateAddress();
}
