package za.co.invoketech.store.model.entity.role;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.google.common.base.Preconditions.*;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 * 
 * An entity representing an Account's role. Used for authorization purposes.
 */
@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROLE_ID")
	private long id;
	
	@Column(name = "ROLE_NAME", nullable = false, unique = true)
	private String roleName;
	
	@Column(name = "DELETED")
	private boolean deleted;
	
	public static Role getInstance(String roleName) {
		checkNotNull(roleName);
		checkArgument(!roleName.isEmpty(), "roleName cannot be empty");
		
		Role role = new Role();
		role.roleName = roleName;
		return role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		checkNotNull(roleName);
		checkArgument(!roleName.isEmpty(), "roleName cannot be empty");
		this.roleName = roleName;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Role)) {
			return false;
		}
		
		Role other = (Role)object;
		if(!this.roleName.equals(other.roleName)) {
			return false;
		}
		return true;
	}
}
