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
import javax.faces.bean.RequestScoped;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.CurrentAccountException;
import za.co.invoketech.store.application.exception.CustomerLinkedException;
import za.co.invoketech.store.application.exception.DefaultDeleteException;
import za.co.invoketech.store.application.util.Faces;
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

@RequestScoped
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
		Goose.guicify(this);
		accounts = accountService.retrieveNonCustomerAccounts();
		roles = roleService.retrieveAllRoles();		
	}
	
	public void populateRolesForAccount() {
		if (selectedAccount != null) setRolesForAccount(selectedAccount.getRoles());
	}
	
	public void removeSelectedAccount() {
		try 
		{
			if (selectedAccount != null) {
				accountService.removeAccount(selectedAccount);
				accounts = accountService.retrieveNonCustomerAccounts();
			}
		} 
		catch (AccountNotFoundException anfe) 
		{
			Faces.showErrorMessage("Delete Error",  "Account Not Found");
		}
		catch (CustomerLinkedException cle) {
			Faces.showErrorMessage("Delete Error",  "Account still has a customer linked");
		}
		catch (DefaultDeleteException dde) {
			Faces.showErrorMessage("Delete Error",  "Cannot delete default accounts");
		}
		catch (CurrentAccountException cae) {
			Faces.showErrorMessage("Delete Error",  "Cant delete currently logged in account");
		}
		catch (Exception e) {
			Faces.showErrorMessage("Delete Error",  "Unknown Error Occurred");
		}
	}


	public void populateAccountsForRole() {
		if (selectedRole != null) setAccountsForRole(accountService.retrieveAccountsForRole(selectedRole));
	}
	/*
	public void removeSelectedRole() {
		try 
		{
			if (selectedRole != null) {
				roleService.removeRole(selectedRole);
				roles = roleService.retrieveAllRoles();
			}
		} 
		catch (RoleNotFoundException anfe) 
		{
			Faces.showErrorMessage("Delete Error",  "Role Not Found");
		}
		catch (AccountLinkedException ale) {
			Faces.showErrorMessage("Delete Error",  "Role still has linked account(s)");
		}
		catch (Exception e) {
			Faces.showErrorMessage("Delete Error",  "Unknown Error Occurred");
		}
	}*/
	
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
