package za.co.invoketech.store.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.model.entity.role.Role;
import za.co.invoketech.store.service.dao.RoleDao;

import com.google.inject.Inject;

@ManagedBean
public class RoleBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RoleDao dao;
	private String roleName;
	
	public RoleBean() {
		Goose.getInjector().injectMembers(this);
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	public void saveRole() {
		Role role = new Role(roleName);
		
		System.out.println(role.getRoleName());
		System.out.println(dao);
		
		dao.persist(role);
	}
}
