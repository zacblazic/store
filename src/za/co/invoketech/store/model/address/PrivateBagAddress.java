package za.co.invoketech.store.model.address;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "ADDRESS_ID")
@Table(name = "PRIVATE_BAG_ADDRESS")
public class PrivateBagAddress extends Address {

	private static final long serialVersionUID = 1L;
	
	private String bagNumber;

	public String getBagNumber() {
		return bagNumber;
	}

	public void setBagNumber(String bagNumber) {
		this.bagNumber = bagNumber;
	}
}
