package za.co.invoketech.store.persistence.internal;

import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.service.repository.CustomerRepository;

import com.google.inject.persist.Transactional;

@Transactional
class CustomerRepositoryImpl extends GenericDaoImpl<Customer, Long> implements CustomerRepository {
	
	public CustomerRepositoryImpl() {
		super(Customer.class);
	}
}
