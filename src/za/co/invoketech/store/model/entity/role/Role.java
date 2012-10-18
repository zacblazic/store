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

package za.co.invoketech.store.model.entity.role;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 * 
 * An entity representing an Account's role. Used for authorization purposes.
 */
@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROLE_ID")
	private long id;
	
	@Column(name = "ROLE_NAME", nullable = false, unique = true)
	private String roleName;
	
	@Column(name = "DELETED")
	private boolean deleted;
	
	public static Role getInstance(String roleName) {
		checkNotNull(roleName);
		checkArgument(!roleName.isEmpty(), "roleName cannot be empty");
		
		Role role = new Role();
		role.roleName = roleName;
		return role;
	}
	
	public Role () {
		
	}
	
	public Role (String roleName) {
		this.roleName = roleName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		checkNotNull(roleName);
		checkArgument(!roleName.isEmpty(), "roleName cannot be empty");
		this.roleName = roleName;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Role)) {
			return false;
		}
		
		Role other = (Role)object;
		if(!this.roleName.equals(other.roleName)) {
			return false;
		}
		return true;
	}
}
