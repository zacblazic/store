package za.co.invoketech.store.model.entity.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import za.co.invoketech.store.model.entity.role.Role;

/** 
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACCOUNT_ID")
	private Long id;
	
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@ManyToMany
	@JoinTable(name = "ACCOUNT_ROLE",
			   joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
			   inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private List<Role> roleList;
	
	@Column(name = "DELETED", nullable = false)
	private boolean deleted;
	
	public static Account getInstance(String email, String password) {
		return getInstance(email, password, new ArrayList<Role>());
	}
	
	public static Account getInstance(String email, String password, List<Role> roleList) {
		Account account = new Account();
		account.email = email;
		account.password = password;
		account.roleList = roleList;
		
		return account;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addRole(Role role) {
		roleList.add(role);
	}
	
	public void removeRole(Role role) {
		roleList.remove(role);
	}
	
	public void removeRole(String roleName) {
		Iterator<Role> iterator = roleList.iterator();
		
		while(iterator.hasNext()) {
			Role role = iterator.next();
			
			if(role.getRoleName().equals(roleName)) {
				iterator.remove();
				break;
			}
		}
	}
	
	public boolean hasRole(Role role) {
		return roleList.contains(role);
	}
	
	public int getRoleCount() {
		return roleList.size();
	}
	
	public void removeAllRoles() {
		roleList = new ArrayList<Role>();
	}
	
	public List<Role> getRoleList() {
		return new ArrayList<Role>(roleList);
	}
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = new ArrayList<Role>(roleList);
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Account)) {
			return false;
		}
		return false;
	}
}
