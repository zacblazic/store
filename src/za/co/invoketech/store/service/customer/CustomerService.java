package za.co.invoketech.store.service.customer;

import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.CustomerNotFoundException;
import za.co.invoketech.store.application.exception.CustomerNotLinkedException;
import za.co.invoketech.store.application.exception.MaximumAddressesReachedException;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.customer.Customer;

public interface CustomerService {

	public static final int MAX_ADDRESSES = 8;
	
	// Customer
	Customer findCustomerById(long customerId) throws CustomerNotFoundException;
	Customer findCustomerByEmail(String email) throws AccountNotFoundException, CustomerNotLinkedException;
	long findCustomerIdByEmail(String email) throws AccountNotFoundException, CustomerNotLinkedException;
	
	// Address
	void addAddress(long customerId, Address address) throws CustomerNotFoundException, MaximumAddressesReachedException;
}
