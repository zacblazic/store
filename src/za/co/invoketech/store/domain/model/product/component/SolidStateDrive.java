package za.co.invoketech.store.domain.model.product.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: SolidStateDrive
 *
 */
@Entity
@Table (name = "SOLID_STATE_DRIVE")
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class SolidStateDrive extends InternalStorage {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "READ_SPEED")
	private int readSpeed;
	
	@Column(name = "WRITE_SPEED")
	private int writeSpeed;
  
	public int getReadSpeed() {
		return this.readSpeed;
	}

	public void setReadSpeed(int readSpeed) {
		this.readSpeed = readSpeed;
	}   
	
	public int getWriteSpeed() {
		return this.writeSpeed;
	}

	public void setWriteSpeed(int writeSpeed) {
		this.writeSpeed = writeSpeed;
	}
}
