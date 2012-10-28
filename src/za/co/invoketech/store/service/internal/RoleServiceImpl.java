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
package za.co.invoketech.store.service.internal;

import java.util.ArrayList;
import java.util.List;

import za.co.invoketech.store.application.exception.AccountLinkedException;
import za.co.invoketech.store.application.exception.InvalidRoleNameException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.account.RoleService;
import za.co.invoketech.store.service.repository.AccountRepository;
import za.co.invoketech.store.service.repository.RoleRepository;

import com.google.inject.Inject;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
public class RoleServiceImpl implements RoleService {

	@Inject
	private RoleRepository roleRepository;
	
	@Inject
	private AccountRepository accountRepository;
	
	@Inject
	private AccountService accountService;
	
	@Override
	public Role createRole(String roleName) throws InvalidRoleNameException {
		if (roleName.contains(" "))
		{
			throw new InvalidRoleNameException();
		}
		
		roleName = roleName.toLowerCase();
		
		// Check for duplicates
		List<Role> roles = roleRepository.findAll();
		for (Role role : roles) {
			if (role.getRoleName().equals(roleName))
				throw new InvalidRoleNameException("Role exists");
		}
		
		Role role = new Role(roleName);
		
		roleRepository.persist(role);
		
		return role;
	}

	@Override
	public Role retrieveRole(long id) throws RoleNotFoundException {
		Role role = roleRepository.findById(id);
		if (role == null || role.getId() == 0)
		{
			throw new RoleNotFoundException();
		}
		
		return role;
	}

	@Override
	public void updateRole(Role role) throws RoleNotFoundException {
		if (role == null || role.getId() == 0)
		{
			throw new RoleNotFoundException();
		}
		
		roleRepository.merge(role);
	}

	@Override
	public void removeRole(Role role) throws RoleNotFoundException, AccountLinkedException {
		if (role == null || role.getId() == 0)
		{
			throw new RoleNotFoundException();
		}
		if (accountService.retrieveAccountsForRole(role).size() != 0)
		{
			throw new AccountLinkedException();
		}
		
		roleRepository.remove(role);
	}

	@Override
	public List<Role> retrieveRolesForAccount(Account account) {
		List<Role> roles;
		if (account == null) roles = new ArrayList<>();
		else roles = accountRepository.findById(account.getId()).getRoles();
		return roles;
	}

	@Override
	public List<Role> retrieveAllRoles() {
		List<Role> roles = roleRepository.findAll();
		return roles;
	}

	@Override
	public Role retrieveRoleByName(String roleName) throws RoleNotFoundException {
		Role role = roleRepository.findByRoleName(roleName);
		if (role == null){
			throw new RoleNotFoundException();
		}
		
		return role;
	}

}
