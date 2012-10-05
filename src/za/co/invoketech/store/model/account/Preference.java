package za.co.invoketech.store.model.account;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PREFERENCE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PREFERENCE_TYPE")
public class Preference implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PREFERENCE_ID")
	private long preferenceId;
	
	private String name;

	public long getPreferenceId() {
		return preferenceId;
	}

	public void setPreferenceId(long preferenceId) {
		this.preferenceId = preferenceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
