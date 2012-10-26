/**
 * Copyright (c) 2012 Invoke Tech
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package za.co.invoketech.store.persistence;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.persistence.internal.PersistenceModule;
import za.co.invoketech.store.service.repository.RoleRepository;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
public class RoleRepositoryTest {
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	private static RoleRepository roleDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		roleDao = injector.getInstance(RoleRepository.class);
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

		// Can't update as role is immutable
		
		// Deletes
		roleDao.remove(newRole);
		Assert.assertNull(roleDao.findById(newRole.getId()));		
	}
}
