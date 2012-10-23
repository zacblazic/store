package za.co.invoketech.store.service.repository;

import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.persistence.dao.GenericDao;

public interface CustomerRepository extends GenericDao<Customer, Long> {

}
