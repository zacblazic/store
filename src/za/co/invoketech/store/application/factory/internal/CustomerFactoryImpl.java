package za.co.invoketech.store.application.factory.internal;

import za.co.invoketech.store.application.factory.CustomerFactory;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.shared.Person;

public class CustomerFactoryImpl implements CustomerFactory {

	@Override
	public Customer createCustomer(Person person, Address address, Account account) {
		return new Customer(person, address, account);
	}
}
