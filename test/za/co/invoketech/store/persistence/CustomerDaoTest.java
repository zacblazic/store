package za.co.invoketech.store.persistence;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
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

public class CustomerDaoTest {

	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	private static AccountRepository accountRepository;
	private static CustomerRepository customerRepository;
	
	private Customer customer;
	private Person person;
	private Account account;
	private Address address;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		accountRepository = injector.getInstance(AccountRepository.class);
		customerRepository = injector.getInstance(CustomerRepository.class);
	}
	
	private Customer createCustomer() {
		person = createPerson();
		address = createAddress();
		account = createAccount();
		return new Customer(person, address, account);
	}
	
	private Person createPerson() {
		return new Person("Zac", "Blazic", Gender.MALE, "0828943000");
	}
	
	private Account createAccount() {
		Account account = new Account("zacblazic@gmail.com", "password");
		accountRepository.persist(account);
		return account;
	}
	
	private Address createAddress() {
		InternalAddress internalAddress = new InternalAddress.Builder("Zac", "Blazic", "0828943000")
			.line1("122 Athens Road")
			.line2("Table View")
			.city("Cape Town")
			.postalCode("7441")
			.country("South Africa")
			.addressType(AddressType.PHYSICAL).build();
		Address address = new Address("Home", internalAddress);
		return address;
	}
	
	@Test
	public void test() {
		// Create
		customer = createCustomer();
		customerRepository.persist(customer);
		Assert.assertTrue(customer.getId() != 0);
		
		// Read
		Customer persistedCustomer = customerRepository.findById(customer.getId());
		Assert.assertNotNull(persistedCustomer);
		
		// Update
		persistedCustomer.setFirstName("Zachari");
		customerRepository.merge(persistedCustomer);
		Customer updatedCustomer = customerRepository.findById(persistedCustomer.getId());
		Assert.assertEquals("Zachari", updatedCustomer.getFirstName());
		
		// Delete
		customerRepository.remove(updatedCustomer);
		Customer removedCustomer = customerRepository.findById(updatedCustomer.getId());
		Assert.assertNull(removedCustomer);
		
		// Remove the account
		accountRepository.remove(account);
	}
}
