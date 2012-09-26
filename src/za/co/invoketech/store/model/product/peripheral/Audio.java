package za.co.invoketech.store.model.product.peripheral;

import java.io.Serializable;
import javax.persistence.*;

import za.co.invoketech.store.model.product.peripheral.Peripheral;

/**
 * Entity implementation class for Entity: Audio
 *
 */
@Entity
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class Audio extends Peripheral implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Audio() {
		super();
	}
   
}
