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
package za.co.invoketech.store.service.account;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.persistence.internal.PersistenceModule;
import za.co.invoketech.store.service.internal.ServiceModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
public class AccountAndRoleServicesTest {
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	private static AccountService accountService;
	private static RoleService roleService;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		injector = Guice.createInjector(new ServiceModule(), new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		accountService = injector.getInstance(AccountService.class);
		roleService = injector.getInstance(RoleService.class);
	}
	
	@Test
	public void accountWithRoleTest() throws Exception {
		
		// Create
		Role role = roleService.createRole("Admin");
		
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
		
		Account acc3 = accountService.retrieveAccount(acc2.getId());
		
		Assert.assertTrue(acc3.getEmail().equals(acc2.getEmail()));
		System.out.println("NoRoleTest: Update Success");
		
		// Delete
		accountService.removeAccount(account);
		roleService.removeRole(role);
		
		try 
		{
			Assert.assertNull(accountService.retrieveAccount(acc3.getId()));
			Assert.assertNull(roleService.retrieveRole(role.getId()));
		} 
		catch (AccountNotFoundException e) 
		{
			System.out.println("NoRoleTest: Delete Account Success");
		} 
		catch (RoleNotFoundException e) 
		{
			System.out.println("NoRoleTest: Delete Role Success");
		}

		
	}

	
	@Test (expected=RoleNotFoundException.class)
	public void accountWithNullRoleTest() throws Exception {		
		// Create
		Account account = accountService.createAccount("garethc@invoketech.co.za", "invoke", null);
		Assert.assertNull(account);
	}

	@Test (expected=RoleNotFoundException.class)
	public void accountWithNonExistentRoleTest() throws Exception {		
		// Create
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role("Admin"));
		
		Account account = accountService.createAccount("garethc@invoketech.co.za", "invoke", roles);
		Assert.assertNull(account);	
	}
	
	@Test (expected=AccountNotFoundException.class)
	public void noAccountTest() throws AccountNotFoundException
	{
		Account account = accountService.retrieveAccount(999999);
		Assert.assertNull(account);		
	}
}
