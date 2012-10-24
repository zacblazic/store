package za.co.invoketech.store.service.internal;

import za.co.invoketech.store.domain.model.account.Account;
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
	public Customer findCustomerById(long id) {
		return customerRepository.findById(id);
	}
	
	@Override
	public Customer findCustomerByEmail(String email) {
		Account account = accountRepository.findByEmail(email);
		
		if(account != null) {
			return account.getCustomer();
		}
		return null;
	}
}
