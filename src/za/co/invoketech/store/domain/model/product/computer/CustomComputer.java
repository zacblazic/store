package za.co.invoketech.store.domain.model.product.computer;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: CustomComputer
 *
 */
@Entity
@Table (name = "CUSTOM_COMPUTER")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class CustomComputer extends Computer {
	
	private static final long serialVersionUID = 1L;
	
}
