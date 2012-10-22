package za.co.invoketech.store.repository.dao.internal;

import za.co.invoketech.store.model.entity.customer.Customer;
import za.co.invoketech.store.service.dao.CustomerDao;

import com.google.inject.persist.Transactional;

@Transactional
class CustomerDaoImpl extends GenericDaoImpl<Customer, Long> implements CustomerDao {
	
	public CustomerDaoImpl() {
		super(Customer.class);
	}
}
