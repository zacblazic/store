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

package za.co.invoketech.store.persistence.internal;

import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.service.repository.RoleRepository;

import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 * @author garethc18@gmail.com (Gareth Conry)
 */
@Singleton
@Transactional
class RoleRepositoryImpl extends GenericDaoImpl<Role, Long> implements RoleRepository {

	public RoleRepositoryImpl() {
		super(Role.class);
	}

	@Override
	public Role findByRoleName(String roleName) {
		return findByAttribute("roleName", roleName.toLowerCase());
	}
}
