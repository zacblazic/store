package za.co.invoketech.store.service.repository;

import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.persistence.dao.GenericDao;

public interface RoleRepository extends GenericDao<Role, Long> {
	Role findByRoleName(String roleName);
}
