package za.co.invoketech.store.model.address;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "ADDRESS_ID")
@Table(name = "PHYSICAL_ADDRESS")
public class PhysicalAddress extends Address {

	private static final long serialVersionUID = 1L;

	private String unitNumber;
	private String streetName;
	
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
}
