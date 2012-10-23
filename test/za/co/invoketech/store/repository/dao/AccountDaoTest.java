package za.co.invoketech.store.repository.dao;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.persistence.internal.PersistenceModule;
import za.co.invoketech.store.service.repository.AccountRepository;
import za.co.invoketech.store.service.repository.RoleRepository;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class AccountDaoTest {
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	private static AccountRepository dao;
	private static RoleRepository roleDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		dao = injector.getInstance(AccountRepository.class);
		roleDao = injector.getInstance(RoleRepository.class);
	}
	
	@Test
	public void accountCrudTest() {
		// Create
		Account account = new Account("garethc@invoketech.co.za", "invoke");
		
		Role x = new Role("Admin");
		roleDao.persist(x);
		Role y = new Role("User");
		roleDao.persist(y);

		account.addRole(x);
		account.addRole(y);
		
		dao.persist(account);
		
		Assert.assertTrue(account.getId() != 0);
		System.out.println(account.getId());
		
		// Read
		Account acc2 = dao.findById(account.getId());
		
		Assert.assertTrue(acc2.getRoleCount() == 2);
		Assert.assertTrue(acc2.getEmail().equals(account.getEmail()));
				
		// Update
		acc2.setEmail("meow@invoketech.co.za");
		
		dao.merge(acc2);
		
		Account acc3 = dao.findById(acc2.getId());
		
		Assert.assertTrue(acc3.getEmail().equals(acc2.getEmail()));
		
		// Delete
		dao.remove(account);
		roleDao.remove(x);
		roleDao.remove(y);

		Assert.assertNull(dao.findById(acc3.getId()));
		Assert.assertNull(roleDao.findById(x.getId()));
		Assert.assertNull(roleDao.findById(y.getId()));	
	}
}
