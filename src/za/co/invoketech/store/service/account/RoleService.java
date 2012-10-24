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
package za.co.invoketech.store.service.account;

import java.util.List;

import za.co.invoketech.store.application.exception.AccountLinkedException;
import za.co.invoketech.store.application.exception.InvalidRoleNameException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.role.Role;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
public interface RoleService {

	public Role createRole(String roleName) throws InvalidRoleNameException;
	public Role retrieveRole(long roleId) throws RoleNotFoundException;
	public void updateRole(Role role) throws RoleNotFoundException;
	public void removeRole(Role role) throws RoleNotFoundException, AccountLinkedException;
	public List<Role> retrieveRolesForAccount(Account account);
	public List<Role> retrieveAllRoles();
}
