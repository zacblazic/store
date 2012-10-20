package za.co.invoketech.store.service.account.internal;

import java.util.List;

import za.co.invoketech.store.application.exception.InvalidRoleNameException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.model.entity.role.Role;
import za.co.invoketech.store.service.account.RoleService;
import za.co.invoketech.store.service.dao.RoleDao;

import com.google.inject.Inject;

public class RoleServiceImpl implements RoleService {

	@Inject
	private RoleDao roleDao;
	
	@Override
	public Role createRole(String roleName) throws InvalidRoleNameException {
		if (roleName.contains(" "))
		{
			throw new InvalidRoleNameException();
		}
		
		roleName = roleName.toLowerCase();
		
		// Check for duplicates
		List<Role> roles = roleDao.findAll();
		for (Role role : roles) {
			if (role.getRoleName().equals(roleName))
				throw new InvalidRoleNameException("Name exists in database");
		}
		
		Role role = new Role(roleName);
		
		roleDao.persist(role);
		
		return role;
	}

	@Override
	public Role retrieveRole(long id) throws RoleNotFoundException {
		Role role = roleDao.findById(id);
		if (role == null || role.getId() == 0)
		{
			throw new RoleNotFoundException();
		}
		
		return role;
	}

	@Override
	public void updateRole(Role role) throws RoleNotFoundException {
		if (role == null || role.getId() == 0)
		{
			throw new RoleNotFoundException();
		}
		
		roleDao.merge(role);
	}

	@Override
	public void removeRole(Role role) throws RoleNotFoundException {
		if (role == null || role.getId() == 0)
		{
			throw new RoleNotFoundException();
		}
		roleDao.remove(role);
	}

}
