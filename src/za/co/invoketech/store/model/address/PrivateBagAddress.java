package za.co.invoketech.store.model.address;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PRIVATE_BAG_ADDRESS")
@PrimaryKeyJoinColumn(name = "ADDRESS_ID")
@DiscriminatorValue("BAG")
public class PrivateBagAddress extends Address {

	private static final long serialVersionUID = 1L;
	
	private String bagNumber;
	private boolean deleted;

	public String getBagNumber() {
		return bagNumber;
	}

	public void setBagNumber(String bagNumber) {
		this.bagNumber = bagNumber;
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
