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
import javax.faces.bean.RequestScoped;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.application.exception.AccountExistsException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.application.util.Faces;
import za.co.invoketech.store.service.account.AccountService;

import com.google.inject.Inject;

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
	
	public AccountController() {
		Goose.guicify(this);
	}

	public AccountBean getAccountBean() {
		return accountBean;
	}

	public void setAccountBean(AccountBean accountBean) {
		this.accountBean = accountBean;
	}
	
	public String add() {
		String returnString = "";
		try {
			accountService.createAccount(accountBean.getEmail(), accountBean.getPassword(), accountBean.toRoleList());
			returnString = "account?faces-redirect=true";
		} catch (AccountExistsException aee) {
			Faces.showErrorMessage("Account Creation Error", "Account already exists");
		}catch (RoleNotFoundException rnfe) {
			Faces.showErrorMessage("Account Creation Error", "Missing role(s)");
		}catch (Exception e) {
			Faces.showErrorMessage("Account Creation Error", "Unknown error occurred" + e.getMessage());
		}
		
		return returnString;
	}
}
