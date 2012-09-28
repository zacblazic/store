package za.co.invoketech.store.model.product.computer;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: CustomComputer
 *
 */
@Entity
@Table (name = "CUSTOM_COMPUTER")
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class CustomComputer extends Computer {
	
	private static final long serialVersionUID = 1L;
	
}
