package za.co.invoketech.store.domain.model.product.computer;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: PreBuiltComputer
 *
 */
@Entity
@Table (name = "PRE_BUILT_COMPUTER")
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class PreBuiltComputer extends Computer {
	
	private static final long serialVersionUID = 1L;
   
}
