package za.co.invoketech.store.service.address.internal;

import java.util.Iterator;
import java.util.List;

import za.co.invoketech.store.application.exception.CustomerNotFoundException;
import za.co.invoketech.store.application.exception.TooManyAddressesException;
import za.co.invoketech.store.model.address.Address;
import za.co.invoketech.store.model.customer.Customer;
import za.co.invoketech.store.service.address.AddressBookService;
import za.co.invoketech.store.service.dao.CustomerDao;

import com.google.inject.Inject;

public class AddressBookServiceImpl implements AddressBookService {

	private static final int MAX_ADDRESSES = 10;
	
	@Inject
	private CustomerDao customerDao;

	@Override
	public void addAddress(Address address, long customerId) throws CustomerNotFoundException, TooManyAddressesException {
		
		Customer customer = customerDao.findById(customerId);
		
		if(customer == null) {
			throw new CustomerNotFoundException();
		}
		
		List<Address> addressList = customer.getAddressBook().getAddressList();
		
		if(addressList.size() < MAX_ADDRESSES) {
			addressList.add(address);
		} else {
			throw new TooManyAddressesException();
		}
		
		customerDao.merge(customer);
	}

	@Override
	public void removeAddress(long addressId, long customerId) throws CustomerNotFoundException {
		
		Customer customer = customerDao.findById(customerId);
		
		if(customer == null) {
			throw new CustomerNotFoundException();
		}
		
		List<Address> addressList = customer.getAddressBook().getAddressList();
		Iterator<Address> iterator = addressList.iterator();
		
		while(iterator.hasNext()) {
			Address address = iterator.next();
			
			if(address.getId() == addressId) {
				iterator.remove();
				break;
			}
		}
		
		customerDao.merge(customer);
	}

	@Override
	public void updateAddress() {
		
		
	}
}
