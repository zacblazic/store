package za.co.invoketech.store.repository.dao.internal;

import za.co.invoketech.store.model.entity.role.Role;
import za.co.invoketech.store.service.dao.RoleDao;

class RoleDaoImpl extends GenericDaoImpl<Role, Long> implements RoleDao{

	public RoleDaoImpl() {
		super(Role.class);
	}

}
