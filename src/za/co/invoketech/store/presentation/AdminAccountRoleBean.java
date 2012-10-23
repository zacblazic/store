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
package za.co.invoketech.store.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.account.RoleService;

import com.google.inject.Inject;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
@SessionScoped
@ManagedBean
public class AdminAccountRoleBean {
	
	@Inject
	private AccountService accountService;
	
	@Inject
	private RoleService roleService;
	
	private List<Account> accounts;
	private List<Role> roles;
	
	private List<Account> accountsForRole;
	private List<Role> rolesForAccount;
	
	private Account selectedAccount;
	private Role selectedRole;
	
	public AdminAccountRoleBean(){
		Goose.getInjector().injectMembers(this);
		accounts = accountService.retrieveAllAccounts();
		roles = roleService.retrieveAllRoles();
	}
	
	public void cows()
	{
		setRolesForAccount(roleService.retrieveRolesForAccount(selectedAccount));
	}

	public Account getSelectedAccount() {
		return selectedAccount;
	}

	public void setSelectedAccount(Account selectedAccount) {
		this.selectedAccount = selectedAccount;
		
	}

	public Role getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public List<Account> getAccountsForRole() {
		return accountsForRole;
	}

	public void setAccountsForRole(List<Account> accountsForRole) {
		this.accountsForRole = accountsForRole;
	}

	public List<Role> getRolesForAccount() {
		return rolesForAccount;
	}

	public void setRolesForAccount(List<Role> rolesForAccount) {
		this.rolesForAccount = rolesForAccount;
	}
	
	
}
