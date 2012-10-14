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

package za.co.invoketech.store.model.entity.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import static com.google.common.base.Preconditions.*;
import za.co.invoketech.store.model.entity.role.Role;

/** 
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACCOUNT_ID")
	private Long id;
	
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@ManyToMany
	@JoinTable(name = "ACCOUNT_ROLE",
			   joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
			   inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private List<Role> roleList;
	
	@Column(name = "DELETED", nullable = false)
	private boolean deleted;
	
	public static Account getInstance(String email, String password) {
		return getInstance(email, password, new ArrayList<Role>());
	}
	
	public static Account getInstance(String email, String password, List<Role> roleList) {
		checkNotNull(email);
		checkNotNull(password);
		checkNotNull(roleList);
		checkArgument(!email.isEmpty(), "email cannot be empty");
		checkArgument(!password.isEmpty(), "password cannot be empty");
		
		Account account = new Account();
		account.email = email;
		account.password = password;
		account.roleList = roleList;
		return account;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		checkNotNull(email);
		checkArgument(!email.isEmpty(), "email cannot be empty");
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		checkNotNull(password);
		checkArgument(!password.isEmpty(), "password cannot be empty");
		this.password = password;
	}
	
	public void addRole(Role role) {
		checkNotNull(role);
		roleList.add(role);
	}
	
	public void removeRole(Role role) {
		checkNotNull(role);
		roleList.remove(role);
	}
	
	public void removeRole(String roleName) {
		checkNotNull(roleName);
		checkArgument(!roleName.isEmpty(), "roleName cannot be empty");
		
		Iterator<Role> iterator = roleList.iterator();
		while(iterator.hasNext()) {
			Role role = iterator.next();
			if(role.getRoleName().equals(roleName)) {
				iterator.remove();
				break;
			}
		}
	}
	
	public boolean hasRole(Role role) {
		checkNotNull(role);
		return roleList.contains(role);
	}
	
	public boolean hasRole(String roleName) {
		checkNotNull(roleName);
		checkArgument(!roleName.isEmpty(), "roleName cannot be empty");
		
		for(Role role : roleList) {
			if(role.getRoleName().equals(roleName)) {
				return true;
			}
		}
		return false;
	}
	
	public int getRoleCount() {
		return roleList.size();
	}
	
	public void removeAllRoles() {
		roleList = new ArrayList<Role>();
	}
	
	public List<Role> getRoleList() {
		return new ArrayList<Role>(roleList);
	}
	
	public void setRoleList(List<Role> roleList) {
		checkNotNull(roleList);
		this.roleList = new ArrayList<Role>(roleList);
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Account)) {
			return false;
		}
		
		Account other = (Account)object;
		if(!this.email.equals(other.email)) {
			return false;
		}
		return true;
	}
}
