package za.co.invoketech.store.repository.dao;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.repository.dao.internal.PersistenceModule;
import za.co.invoketech.store.service.dao.RoleDao;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class RoleDaoTest {
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	private static RoleDao roleDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		roleDao = injector.getInstance(RoleDao.class);
	}
	
	@Test
	public void roleCrudTest()
	{
		// Create
		Role role = new Role("User");
		roleDao.persist(role);
		Assert.assertTrue(role.getId() != 0);
		
		// Read
		Role newRole = roleDao.findById(role.getId());
		Assert.assertTrue(role.equals(newRole));
		
		// Update
		newRole.setRoleName("Shopper");
		roleDao.merge(newRole);
		
		Role newRole2 = roleDao.findById(newRole.getId());
		Assert.assertTrue(newRole2.getRoleName().equals(newRole.getRoleName()));
		
		// Deletes
		roleDao.remove(newRole2);
		Assert.assertNull(roleDao.findById(newRole2.getId()));		
	}
}
