package za.co.invoketech.store.model.address;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="ADDRESS_ID")
@Table(name="POST_OFFICE_BOX_ADDRESS")
public class PostOfficeBoxAddress extends Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int boxNumber;

	public int getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(int boxNumber) {
		this.boxNumber = boxNumber;
	}
}
