package za.co.invoketech.store.model;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.application.util.Constants;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.customer.Customer;
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
	
	
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
