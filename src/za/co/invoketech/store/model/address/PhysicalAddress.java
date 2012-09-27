package za.co.invoketech.store.model.address;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="ADDRESS_ID")
@Table(name="PHYSICAL_ADDRESS")
public class PhysicalAddress extends Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private int unitNumber;
	private String streetName;
	
	public int getUnitNumber() {
		return unitNumber;
	}
	
	public void setUnitNumber(int unitNumber) {
		this.unitNumber = unitNumber;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
}
