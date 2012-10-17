package za.co.invoketech.store.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import za.co.invoketech.store.model.entity.role.Role;
import za.co.invoketech.store.service.dao.RoleDao;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

@ManagedBean
@RequestScoped
public class RoleBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RoleDao roleDao;
	
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public void saveRole()
	{
		Role role = Role.getInstance(roleName);
		roleDao.persist(role);
	}
	
}
