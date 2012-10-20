package za.co.invoketech.store.service.file;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.NonExistentRoleException;
import za.co.invoketech.store.model.entity.account.Account;
import za.co.invoketech.store.model.entity.role.Role;
import za.co.invoketech.store.repository.dao.internal.PersistenceModule;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.account.internal.AccountRoleModule;
import za.co.invoketech.store.service.dao.AccountDao;
import za.co.invoketech.store.service.dao.RoleDao;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class AccountAndRoleServicesTest {
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	private static AccountDao dao;
	private static RoleDao roleDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		injector = Guice.createInjector(new PersistenceModule(), new AccountRoleModule(), new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		dao = injector.getInstance(AccountDao.class);
		roleDao = injector.getInstance(RoleDao.class);
	}
	
	@Test
	public void withRoleTest() throws NonExistentRoleException, AccountNotFoundException {
		
		AccountService accountService = injector.getInstance(AccountService.class);
		
		// Create
		Role role = new Role("Admin");
		roleDao.persist(role);
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		
		Account account = accountService.createAccount("garethc@invoketech.co.za", "invoke", roles);
		
		Assert.assertTrue(account.getId() != 0);
		System.out.println("Account ID is: " + account.getId());
		System.out.println("NoRoleTest: Persist Success");
		
		// Read
		Account acc2 = accountService.retrieveAccount(account.getId());
		
		Assert.assertTrue(acc2.getEmail().equals(account.getEmail()));
		System.out.println("NoRoleTest: Read Success");
		
		// Update
		acc2.setEmail("meow@invoketech.co.za");
		
		accountService.updateAccount(acc2);
		
		Account acc3 = dao.findById(acc2.getId());
		
		Assert.assertTrue(acc3.getEmail().equals(acc2.getEmail()));
		System.out.println("NoRoleTest: Update Success");
		
		// Delete
		accountService.removeAccount(account);
		roleDao.remove(role);

		Assert.assertNull(dao.findById(acc3.getId()));
		Assert.assertNull(roleDao.findById(role.getId()));
		System.out.println("NoRoleTest: Delete Success");
		
	}

	
	@SuppressWarnings("unused")
	@Test (expected=NonExistentRoleException.class)
	public void withNullRoleTest() throws NonExistentRoleException {
		
		AccountService accountService = injector.getInstance(AccountService.class);
		
		// Create
		Account account = accountService.createAccount("garethc@invoketech.co.za", "invoke", null);
				
	}

	
	@SuppressWarnings("unused")
	@Test (expected=NonExistentRoleException.class)
	public void withNonExistentRoleTest() throws NonExistentRoleException {
		
		AccountService accountService = injector.getInstance(AccountService.class);
		
		// Create
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role("Admin"));
		
		Account account = accountService.createAccount("garethc@invoketech.co.za", "invoke", roles);		
	}
	
	@Test (expected=AccountNotFoundException.class)
	public void noAccountTest() throws AccountNotFoundException
	{
		AccountService accountService = injector.getInstance(AccountService.class);
		accountService.retrieveAccount(999999);
	}
}
