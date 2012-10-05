package za.co.invoketech.store.model.address;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "POST_OFFICE_BOX_ADDRESS")
@PrimaryKeyJoinColumn(name = "ADDRESS_ID")
@DiscriminatorValue("BOX")
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
