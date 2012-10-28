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
package za.co.invoketech.store.presentation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.application.util.Faces;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.service.account.RoleService;

import com.google.inject.Inject;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
@ViewScoped
@ManagedBean
public class AccountBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private RoleService roleService;
	
	private long id;
	
	private String email;
	private String password;
	private String confirmPassword;
	
	private boolean admin;
	private boolean manager;
	private boolean customer;
	
	public AccountBean() {
		Goose.guicify(this);
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public boolean isManager() {
		return manager;
	}
	
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	
	public boolean isCustomer() {
		return customer;
	}

	public void setCustomer(boolean customer) {
		this.customer = customer;
	}

	public Account toAccount() {
		return new Account(email, password, getRoles());
	}
	
	public List<Role> getRoles() {
		List<Role> roles = new ArrayList<>();
		try {				
			if (isAdmin()) {
				roles.add(roleService.retrieveRoleByName("admin"));
			}
			if (isManager()) {
				roles.add(roleService.retrieveRoleByName("manager"));
			}
			if(isCustomer()) {
				roles.add(roleService.retrieveRoleByName("customer"));
			}
		} catch (RoleNotFoundException rnfe) {
			Faces.showErrorMessage("Role Error", "Missing role(s)");
		}
		return roles;
	}
}
