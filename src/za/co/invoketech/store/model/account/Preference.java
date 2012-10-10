package za.co.invoketech.store.model.account;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PREFERENCE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PREFERENCE_TYPE")
public abstract class Preference implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PREFERENCE_ID")
	private long id;
	
	@Column(name = "NAME")
	protected String name;
	
	@Column(name = "DELETED")
	protected boolean deleted;
	
	public Preference() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
