package za.co.invoketech.store.model.address;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PHYSICAL_ADDRESS")
@PrimaryKeyJoinColumn(name = "ADDRESS_ID")
@DiscriminatorValue("PHYSICAL")
public class PhysicalAddress extends Address {

	private static final long serialVersionUID = 1L;

	private String unitNumber;
	private String streetName;
	private boolean deleted;
	
	public String getUnitNumber() {
		return unitNumber;
	}
	
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
