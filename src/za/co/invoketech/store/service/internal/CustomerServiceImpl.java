package za.co.invoketech.store.service.internal;

import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.CustomerNotFoundException;
import za.co.invoketech.store.application.exception.CustomerNotLinkedException;
import za.co.invoketech.store.application.exception.MaximumAddressesReachedException;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.service.customer.CustomerService;
import za.co.invoketech.store.service.repository.AccountRepository;
import za.co.invoketech.store.service.repository.CustomerRepository;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class CustomerServiceImpl implements CustomerService {

	@Inject CustomerRepository customerRepository;
	@Inject AccountRepository accountRepository;
	
	@Override
	public Customer findCustomerById(long id) throws CustomerNotFoundException {
		Customer customer = customerRepository.findById(id);
		
		if(customer == null) {
			throw new CustomerNotFoundException();
		}
		return customer;
	}
	
	@Override
	public Customer findCustomerByEmail(String email) throws AccountNotFoundException, CustomerNotLinkedException {
		Account account = accountRepository.findByEmail(email);
		
		if(account == null) {
			throw new AccountNotFoundException();
		}
		
		Customer customer = account.getCustomer();
		
		if(customer == null) {
			throw new CustomerNotLinkedException();
		}
		
		return customer;
	}
	
	@Override
	public long findCustomerIdByEmail(String email) throws AccountNotFoundException, CustomerNotLinkedException {
		Customer customer = findCustomerByEmail(email);
		return customer.getId();
	}
	
	@Override
	public void addAddress(long customerId, Address address) throws CustomerNotFoundException, MaximumAddressesReachedException {
		Customer customer = customerRepository.findById(customerId);
		
		if(customer == null) {
			throw new CustomerNotFoundException();
		}
		
		if(customer.getAddressCount() > MAX_ADDRESSES) {
			throw new MaximumAddressesReachedException();
		}
		
		customer.addAddress(address);
		customerRepository.merge(customer);
	}
}
