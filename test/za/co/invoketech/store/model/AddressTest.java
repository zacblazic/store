package za.co.invoketech.store.model;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.application.util.Constants;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.shared.AddressType;
import za.co.invoketech.store.domain.shared.Gender;
import za.co.invoketech.store.domain.shared.InternalAddress;
import za.co.invoketech.store.domain.shared.Person;
import za.co.invoketech.store.persistence.internal.PersistenceModule;
import za.co.invoketech.store.service.repository.AccountRepository;
import za.co.invoketech.store.service.repository.CustomerRepository;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class AddressTest {

	private static Injector injector;
	private static AccountRepository accountRepository;
	private static CustomerRepository customerRepository;
	
	private Person person;
	private Address address;
	private Account account;
	private Customer customer;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule(Constants.PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		accountRepository = injector.getInstance(AccountRepository.class);
		customerRepository = injector.getInstance(CustomerRepository.class);
	}
	
	private Person createPerson() {
		return new Person("Zac", "Blazic", Gender.MALE, "0828943000");
	}
	
	private Address createAddress() {
		InternalAddress internalAddress = new InternalAddress.Builder("Zac", "Blazic", "0828943000")
			.line1("122 Athens Road")
			.line2("Table View")
			.city("Cape Town")
			.postalCode("7441")
			.country("South Africa")
			.addressType(AddressType.PHYSICAL).build();
		return new Address("Home", internalAddress);
	}
	
	private Account createAccount() {
		Account account = new Account("zacblazic@gmail.com", "password");
		accountRepository.persist(account);
		return account;
	}
	
	private Customer createCustomer() {
		person = createPerson();
		address = createAddress();
		account = createAccount();
		return new Customer(person, address, account);
	}
	
	@Test
	public void test() {
		customer = createCustomer();
		customerRepository.persist(customer);
	}
}