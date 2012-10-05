package za.co.invoketech.store.model.address;

import javax.persistence.Entity;

@Entity
public class PostOfficeBoxAddress extends Address {

	private static final long serialVersionUID = 1L;
	
	private String boxNumber;

	public String getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}
}
