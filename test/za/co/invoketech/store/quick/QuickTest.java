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
package za.co.invoketech.store.quick;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.persistence.internal.PersistenceModule;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.account.RoleService;
import za.co.invoketech.store.service.internal.ServiceModule;
import za.co.invoketech.store.service.repository.AccountRepository;
import za.co.invoketech.store.service.repository.CustomerRepository;
import za.co.invoketech.store.service.repository.RoleRepository;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
public class QuickTest {
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	private static AccountService accountService;
	private static RoleService roleService;
	private static CustomerRepository customerDao;
	private static AccountRepository accountDao;
	private static RoleRepository roleRepository;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		injector = Guice.createInjector(new ServiceModule(), new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		accountService = injector.getInstance(AccountService.class);
		roleService = injector.getInstance(RoleService.class);
		customerDao = injector.getInstance(CustomerRepository.class);
		accountDao = injector.getInstance(AccountRepository.class);
		roleRepository = injector.getInstance(RoleRepository.class);
	}

//	@Test
//	public void test() throws AccountNotFoundException, RoleNotFoundException {
//		List<Role> newRoles = new ArrayList<>();
//		newRoles.add(new Role("admin"));
//		
//		Account acc = accountDao.findById(4L);
//		acc.setRoles(newRoles);
//		
//		accountService.updateAccount(acc);
//		
//		
//	}
	
	@Test
	public void testThisStuffOk() throws RoleNotFoundException {
		List<Role> newRoles = new ArrayList<>();
		newRoles.add(new Role("admin"));
		
		Account account = accountDao.findById(4L);
		account.setRoles(newRoles);
		
		if (account.getRoles() != null && account.getRoles().size() != 0)
		{
			// Find if roles exist
			List<Role> dbRoles = new ArrayList<Role>();
			
			for (Role role : account.getRoles()) {
				System.out.println(role.getRoleName());
				Role foundRole = roleRepository.findByRoleName(role.getRoleName());
				System.out.println("here");
				if (foundRole == null) throw new RoleNotFoundException();
				else dbRoles.add(foundRole);				
			}				
			
			System.out.println("done");
			account.setRoles(dbRoles);			
		}
		else throw new RoleNotFoundException("No role assigned");
	}

}
