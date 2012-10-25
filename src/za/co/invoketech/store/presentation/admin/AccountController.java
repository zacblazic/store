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
package za.co.invoketech.store.presentation.admin;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.application.exception.AccountExistsException;
import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.application.util.Faces;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.service.account.AccountService;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
@RequestScoped
@ManagedBean
public class AccountController {

	@Inject 
	private AccountService accountService;
	
	@ManagedProperty(value = "#{accountBean}")
	private AccountBean accountBean;
	
	@ManagedProperty(value = "#{param.id}")
	private long accountId;
		
	private Account account;
	
	public AccountController() {
		Goose.guicify(this);
	}
	
	public void populateFields() {		
		if (accountId != 0){
			try {
				account = accountService.retrieveAccount(accountId);
			} catch (AccountNotFoundException anfe) {
				Faces.showErrorMessage("Account Edit Error", "Account not found");
			} catch (Exception e) {
				Faces.showErrorMessage("Account Edit Error", "Unknown Error: ");
				e.printStackTrace();
			}
			accountBean.setId(accountId);
			accountBean.setEmail(account.getEmail());
			
			for (Role role : account.getRoles()) {
				if (role.getRoleName().equals("admin")) accountBean.setAdmin(true);
				else if (role.getRoleName().equals("manager")) accountBean.setManager(true);
			}
		}
	}

	public AccountBean getAccountBean() {
		return accountBean;
	}

	public void setAccountBean(AccountBean accountBean) {
		this.accountBean = accountBean;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}	

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String add() {
		String returnString = "";
		try {
			if (accountBean.getPassword().equals(accountBean.getConfirmPassword()))
			{
				accountService.createAccount(accountBean.getEmail(), accountBean.getPassword(), accountBean.toRoleList());
				returnString = "account?faces-redirect=true";
			}
			else 
			{
				Faces.showErrorMessage("Account Creation Error", "Passwords do not match");
			}
		} catch (AccountExistsException aee) {
			Faces.showErrorMessage("Account Creation Error", "Account already exists");
		}catch (RoleNotFoundException rnfe) {
			Faces.showErrorMessage("Account Creation Error", "Missing role(s)");
		}catch (Exception e) {
			Faces.showErrorMessage("Account Creation Error", "Unknown error: " + e.getMessage());
		}
		
		return returnString;
	}
	
	public String update() {
		String returnString = "";
		try {
			if (accountBean.getPassword().equals(accountBean.getConfirmPassword()))
			{
				account = accountService.retrieveAccount(accountBean.getId());
				PasswordService psvc = new DefaultPasswordService();
				account.setPassword(psvc.encryptPassword((String)accountBean.getPassword()));
				account.setRoles(accountBean.toRoleList());
				
				accountService.updateAccount(account);
				returnString = "account?faces-redirect=true";
			}
			
			else 
			{
				Faces.showErrorMessage("Account Edit Error", "Passwords do not match");
			}
			
		} catch (AccountNotFoundException anfe) {
			Faces.showErrorMessage("Account Edit Error", "Account not found");
		} catch (Exception e) {
			Faces.showErrorMessage("Account Edit Error", "Unknown Error: ");
			e.printStackTrace();
		}
		
		return returnString;
	}
}
