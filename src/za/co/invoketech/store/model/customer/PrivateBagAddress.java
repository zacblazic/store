package za.co.invoketech.store.model.customer;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="ADDRESS_ID")
@Table(name="PRIVATE_BAG_ADDRESS")
public class PrivateBagAddress extends Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int bagNumber;

	public int getBagNumber() {
		return bagNumber;
	}

	public void setBagNumber(int bagNumber) {
		this.bagNumber = bagNumber;
	}
}
