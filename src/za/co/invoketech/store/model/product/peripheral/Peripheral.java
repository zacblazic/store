package za.co.invoketech.store.model.product.peripheral;

import java.io.Serializable;
import javax.persistence.*;

import za.co.invoketech.store.model.product.Product;

/**
 * Entity implementation class for Entity: Peripheral
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class Peripheral extends Product implements Serializable {

	private static final long serialVersionUID = 1L;

	public Peripheral() {
		super();
	}
   
}
