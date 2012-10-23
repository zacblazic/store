package za.co.invoketech.store.persistence.internal;

import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.service.repository.RoleRepository;

import com.google.inject.persist.Transactional;

@Transactional
class RoleRepositoryImpl extends GenericDaoImpl<Role, Long> implements RoleRepository{

	public RoleRepositoryImpl() {
		super(Role.class);
	}
}
