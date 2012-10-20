package za.co.invoketech.store.service.account;

import za.co.invoketech.store.application.exception.InvalidRoleNameException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.model.entity.role.Role;

public interface RoleService {

	Role createRole(String roleName) throws InvalidRoleNameException;

	Role retrieveRole(long roleId) throws RoleNotFoundException;

	void updateRole(Role role) throws RoleNotFoundException;

	void removeRole(Role role) throws RoleNotFoundException;

}
