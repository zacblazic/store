package za.co.invoketech.store.domain.model.product.peripheral;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Keyboard
 *
 */
@Entity
@Table (name = "KEYBOARD")
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class Keyboard extends Peripheral {
	
	private static final long serialVersionUID = 1L;
   
}
