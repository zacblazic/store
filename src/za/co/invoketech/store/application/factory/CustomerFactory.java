package za.co.invoketech.store.application.factory;

import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.shared.Person;

public interface CustomerFactory {

	Customer createCustomer(Person person, Address address, Account account);
}
