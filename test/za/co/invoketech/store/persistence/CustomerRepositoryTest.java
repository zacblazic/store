package za.co.invoketech.store.persistence;
//package za.co.invoketech.store.repository.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import junit.framework.Assert;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import za.co.invoketech.store.application.config.ApplicationInitializer;
//import za.co.invoketech.store.model.entity.account.Account;
//import za.co.invoketech.store.model.entity.customer.Customer;
//import za.co.invoketech.store.model.entity.customer.CustomerAddress;
//import za.co.invoketech.store.model.value.AddressType;
//import za.co.invoketech.store.repository.dao.internal.PersistenceModule;
//import za.co.invoketech.store.service.dao.AccountDao;
//import za.co.invoketech.store.service.dao.CustomerDao;
//
//import com.google.inject.Guice;
//import com.google.inject.Injector;
//import com.google.inject.persist.jpa.JpaPersistModule;
//
//public class CustomerDaoTest {
//
//	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
//	private static Injector injector;
//	private static AccountDao accountDao;
//	private static CustomerDao customerDao;
//	
//	private Customer customer;
//	private Account account;
//	
//	@BeforeClass
//	public static void setUpBeforeClass() {
//		injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
//		injector.getInstance(ApplicationInitializer.class);
//		accountDao = injector.getInstance(AccountDao.class);
//		customerDao = injector.getInstance(CustomerDao.class);
//	}
//	
//	private Customer createCustomer() {
//		account = createAccount();
//		
//		Customer customer = null;
//		
//		return customer;
//	}
//	
//	private Account createAccount() {
//		Account account = new Account("zacblazic@gmail.com", "password");
//		accountDao.persist(account);
//		
//		return account;
//	}
//	
//	private List<CustomerAddress> createAddresses(CustomerAddress address) {
//		List<CustomerAddress> addresses = new ArrayList<CustomerAddress>();
//		addresses.add(address);
//		
//		return addresses;
//	}
//	
//	private CustomerAddress createAddress() {
//		CustomerAddress address = new CustomerAddress.Builder("Home")
//		.firstName("Zac")
//		.lastName("Blazic")
//		.phoneNumber("0828943000")
//		.line1("122 Athens Road")
//		.line2("Table View")
//		.city("Cape Town")
//		.postalCode("7441")
//		.country("South Africa")
//		.addressType(AddressType.PHYSICAL).build();
//		
//		return address;
//	}
//	
//	@Test
//	public void test() {
//		// Create
//		customer = createCustomer();
//		Assert.assertTrue(customer.getId() != 0);
//		
//		// Read
//		Customer persistedCustomer = customerDao.findById(customer.getId());
//		Assert.assertNotNull(persistedCustomer);
//		
//		// Update
//		persistedCustomer.setFirstName("Zachari");
//		customerDao.merge(persistedCustomer);
//		Customer updatedCustomer = customerDao.findById(persistedCustomer.getId());
//		Assert.assertEquals("Zachari", updatedCustomer.getFirstName());
//		
//		// Delete
//		customerDao.remove(updatedCustomer);
//		Customer removedCustomer = customerDao.findById(updatedCustomer.getId());
//		Assert.assertNull(removedCustomer);
//		
//		// Remove the account
//		accountDao.remove(account);
//	}
//}
