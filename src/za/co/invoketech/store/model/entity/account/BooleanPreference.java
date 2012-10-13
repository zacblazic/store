package za.co.invoketech.store.model.entity.account;

import javax.persistence.Column;
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
	private static final boolean DEFAULT_BOOLEAN_PREFERENCE_VALUE = false;
	
	@Column(name = "VALUE")
	private boolean value;
	
	public static BooleanPreference getInstance(String name) {
		return getInstance(name, DEFAULT_BOOLEAN_PREFERENCE_VALUE);
	}
	
	public static BooleanPreference getInstance(String name, boolean value) {
		BooleanPreference preference = new BooleanPreference();
		preference.name = name;
		preference.value = value;
		
		return preference;
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
}
