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
package za.co.invoketech.store.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.application.exception.InvalidRoleNameException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.domain.shared.Person;
import za.co.invoketech.store.persistence.internal.PersistenceModule;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.account.RoleService;
import za.co.invoketech.store.service.account.internal.AccountRoleModule;
import za.co.invoketech.store.service.repository.CustomerRepository;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
public class CreateAccountRoleTestData {
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	private static AccountService accountService;
	private static RoleService roleService;
	private static CustomerRepository customerDao;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		injector = Guice.createInjector(new AccountRoleModule(), new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		accountService = injector.getInstance(AccountService.class);
		roleService = injector.getInstance(RoleService.class);
		customerDao = injector.getInstance(CustomerRepository.class);
	}
	
	@Test
	public void createData() throws RoleNotFoundException, InvalidRoleNameException {
		Role admin = roleService.createRole("Admin");
		Role manager = roleService.createRole("Manager");
		Role user = roleService.createRole("User");

		List<Role> adminAndManagerRole = new ArrayList<Role>();
		adminAndManagerRole.add(roleService.retrieveRole(admin.getId()));
		adminAndManagerRole.add(roleService.retrieveRole(manager.getId()));
		
		List<Role> managerRole = new ArrayList<Role>();
		managerRole.add(roleService.retrieveRole(manager.getId()));
		
		List<Role> userRole = new ArrayList<Role>();
		userRole.add(roleService.retrieveRole(user.getId()));
		
		accountService.createAccount("gconry@invoketech.co.za", "iamadmin", adminAndManagerRole);
		accountService.createAccount("manager@invoketech.co.za", "iammanager",managerRole);
		Account userAcc = accountService.createAccount("garethc18@gmail.com", "iamuser", userRole);
		
		Person p = new Person("Mr", "Gareth", "TheUser", "0839491159");
		Customer cust = new Customer(p, userAcc);
		
		customerDao.persist(cust);
	}

}
