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

import org.junit.Test;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.domain.shared.AddressType;
import za.co.invoketech.store.domain.shared.Gender;
import za.co.invoketech.store.domain.shared.InternalAddress;
import za.co.invoketech.store.domain.shared.Person;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.account.RoleService;
import za.co.invoketech.store.service.repository.CustomerRepository;

import com.google.inject.Inject;

/**
 * @author garethc18@gmail.com (Gareth Conry)
 * @author zacblazic@gmail.com (Zac Blazic)
 */
public class CreateAccountRoleTestData{

	@Inject private AccountService accountService;
	@Inject private RoleService roleService;
	@Inject private CustomerRepository customerRepository;

	public CreateAccountRoleTestData() {
		Goose.getInjectorForTesting().injectMembers(this);
	}
	
	private Address createAddress() {
		InternalAddress internalAddress = new InternalAddress.Builder()
			.firstName("Zac")
			.lastName("Blazic")
			.phoneNumber("0828943000")
			.line1("122 Athens Road")
			.line2("Table View")
			.city("Cape Town")
			.postalCode("7441")
			.country("South Africa")
			.addressType(AddressType.PHYSICAL).build();
		return new Address("Home", internalAddress);
	}
	
	@Test
	public void createData()  throws Exception {
		// Create roles
		Role adminRole = roleService.createRole("Admin");
		Role managerRole = roleService.createRole("Manager");
		Role customerRole = roleService.createRole("Customer");

		// Add roles to lists
		List<Role> adminAndManagerRoles = new ArrayList<Role>();
		adminAndManagerRoles.add(roleService.retrieveRole(adminRole.getId()));
		adminAndManagerRoles.add(roleService.retrieveRole(managerRole.getId()));
		
		List<Role> managerRoles = new ArrayList<Role>();
		managerRoles.add(roleService.retrieveRole(managerRole.getId()));
		
		List<Role> customerRoles = new ArrayList<Role>();
		customerRoles.add(roleService.retrieveRole(customerRole.getId()));
		
		// Create persons
		Person gareth = new Person("Gareth", "Conry", Gender.MALE, "0839491159");
		Person zac = new Person("Zac", "Blazic", Gender.MALE, "0828943000");
		Person carel = new Person("Carel", "Nel", Gender.MALE, "0825003000");
		
		// Create accounts
		accountService.createAccount("admin@invoketech.co.za", "adminpass", adminAndManagerRoles);
		accountService.createAccount("manager@invoketech.co.za", "iammanager",managerRoles);
		accountService.createAccount("gconry@invoketech.co.za", "iamadmin", adminAndManagerRoles);
		accountService.createAccount("zacblazic@invoketech.co.za", "adminpass", adminAndManagerRoles);
		accountService.createAccount("cnel@invoketech.co.za", "adminpass", adminAndManagerRoles);

		Account garethCustAcc = accountService.createAccount("garethc18@gmail.com", "iamuser", customerRoles);
		Account zacCustAcc = accountService.createAccount("zacblazic@gmail.com", "password", customerRoles);
		Account carelCustAcc = accountService.createAccount("a.carel.g.nel@gmail.com", "password", customerRoles);
		
		Customer garethCustomer = new Customer(gareth, createAddress(), garethCustAcc);
		Customer zacCustomer = new Customer(zac, createAddress(), zacCustAcc);
		Customer carelCustomer = new Customer(carel, createAddress(), carelCustAcc);
		
		customerRepository.persist(garethCustomer);
		customerRepository.persist(zacCustomer);
		customerRepository.persist(carelCustomer);
	}
}
