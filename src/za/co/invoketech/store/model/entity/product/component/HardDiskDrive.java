package za.co.invoketech.store.model.entity.product.component;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import za.co.invoketech.store.model.entity.product.component.InternalStorage;

/**
 * Entity implementation class for Entity: HardDiskDrive
 *
 */
@Entity
@Table (name = "HARD_DISK_DRIVE")
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class HardDiskDrive extends InternalStorage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "SPIN_RATE")
	private String spinRate;

	public HardDiskDrive() {
		super();
	}   
	public String getSpinRate() {
		return this.spinRate;
	}

	public void setSpinRate(String spinRate) {
		this.spinRate = spinRate;
	}
   
}
