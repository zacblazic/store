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

package za.co.invoketech.store.domain.model.account;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.model.role.Role;

/** 
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ACCOUNT_ID")
	private long id;
	
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@ManyToMany
	@JoinTable(name = "ACCOUNT_ROLE",
			   joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
			   inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private List<Role> roles;
	
	@OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID")
	private Customer customer;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public Account() {}
	
	public Account (String email, String password){
		this(email, password, new ArrayList<Role>());
	}
	
	public Account (String email, String password, List<Role> roles){
		checkEmail(email);
		checkPassword(password);
		checkRoles(roles);
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		checkEmail(email);
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		checkPassword(password);
		this.password = password;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void addRole(Role role) {
		checkRole(role);
		roles.add(role);
	}
	
	public void removeRole(Role role) {
		checkRole(role);
		roles.remove(role);
	}
	
	public boolean hasRole(Role role) {
		checkRole(role);
		return roles.contains(role);
	}
	
	public boolean hasRole(String roleName) {
		checkRoleName(roleName);
		for(Role role : roles) {
			if(role.getRoleName().equalsIgnoreCase(roleName)) {
				return true;
			}
		}
		return false;
	}
	
	public int getRoleCount() {
		return roles.size();
	}
	
	public void removeAllRoles() {
		roles = new ArrayList<Role>();
	}
	
	public List<Role> getRoles() {
		return new ArrayList<>(roles);
	}
	
	public void setRoles(List<Role> roles) {
		checkRoles(roles);
		this.roles = new ArrayList<>(roles);
	}

	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Account)) {
			return false;
		}
		
		Account other = (Account)object;
		if(!this.email.equalsIgnoreCase(other.email)) {
			return false;
		}
		return true;
	}
	
	private void checkEmail(String email) {
		checkNotNull(email, "email cannot be null");
		checkArgument(!email.isEmpty(), "email cannot be empty");
	}
	
	private void checkPassword(String password) {
		checkNotNull(password, "password cannot be null");
		checkArgument(!password.isEmpty(), "password cannot be empty");
	}
	
	private void checkRoleName(String roleName) {
		checkNotNull(roleName, "roleName cannot be null");
		checkArgument(!roleName.isEmpty(), "roleName cannot be empty");
	}
	
	private void checkRole(Role role) {
		checkNotNull(role, "role cannot be null");
	}
	
	private void checkRoles(List<Role> roles) {
		checkNotNull(roles, "roles cannot be null");
		checkArgument(!roles.contains(null), "roles cannot contain nulls");
	}
}
