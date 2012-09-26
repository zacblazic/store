package za.co.invoketech.store.model.product.peripheral;

import java.io.Serializable;
import javax.persistence.*;

import za.co.invoketech.store.model.product.peripheral.Peripheral;

/**
 * Entity implementation class for Entity: Display
 *
 */
@Entity
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class Display extends Peripheral implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Display() {
		super();
	}
   
}
