package za.co.invoketech.store.model.account;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "BOOLEAN_PREFERENCE")
@PrimaryKeyJoinColumn(name = "PREFERENCE_ID")
@DiscriminatorValue("BOOLEAN")
public class BooleanPreference extends Preference {
	
	private static final long serialVersionUID = 1L;

	private boolean value;

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
}
