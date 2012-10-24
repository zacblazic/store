package za.co.invoketech.store.service.customer;

import za.co.invoketech.store.domain.model.customer.Customer;

public interface CustomerService {

	Customer findCustomerByEmail(String email);
}
