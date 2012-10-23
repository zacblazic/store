package za.co.invoketech.store.service.account;

import java.util.List;

import za.co.invoketech.store.application.exception.InvalidRoleNameException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.model.entity.account.Account;
import za.co.invoketech.store.model.entity.role.Role;

public interface RoleService {

	public Role createRole(String roleName) throws InvalidRoleNameException;
	public Role retrieveRole(long roleId) throws RoleNotFoundException;
	public void updateRole(Role role) throws RoleNotFoundException;
	public void removeRole(Role role) throws RoleNotFoundException;
	public List<Role> retrieveRolesForAccount(Account account);
	public List<Role> retrieveAllRoles();
}
