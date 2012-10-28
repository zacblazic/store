package za.co.invoketech.store.service.internal;

import za.co.invoketech.store.application.exception.AccountExistsException;
import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.CustomerNotFoundException;
import za.co.invoketech.store.application.exception.CustomerNotLinkedException;
import za.co.invoketech.store.application.exception.MaximumAddressesReachedException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.application.factory.CustomerFactory;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.shared.Person;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.account.RoleService;
import za.co.invoketech.store.service.customer.CustomerService;
import za.co.invoketech.store.service.repository.AccountRepository;
import za.co.invoketech.store.service.repository.CustomerRepository;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class CustomerServiceImpl implements CustomerService {

	@Inject CustomerFactory customerFactory;
	@Inject CustomerRepository customerRepository;
	@Inject AccountRepository accountRepository;
	@Inject AccountService accountService;
	@Inject RoleService roleService;
	
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
	
	@Override
	public void createCustomer(Person person, Address address, Account account) throws RoleNotFoundException, AccountExistsException {
		// Give the custome the default "customer" role
		account.addRole(roleService.retrieveRoleByName("customer"));
		
		// Create the account
		Account createdAccount = accountService.createAccount(account.getEmail(), account.getPassword(), account.getRoles());
		
		// Create teh customer and persist it
		Customer customer = customerFactory.createCustomer(person, address, createdAccount);
		customerRepository.persist(customer);
		
		createdAccount.setCustomer(customer);
		try {
			accountService.updateAccount(createdAccount);
		} catch (AccountNotFoundException e) {


			e.printStackTrace();
		}
	}
}
