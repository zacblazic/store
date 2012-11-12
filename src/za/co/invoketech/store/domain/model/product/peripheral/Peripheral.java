package za.co.invoketech.store.domain.model.product.peripheral;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import za.co.invoketech.store.domain.model.product.Product;

/**
 * Entity implementation class for Entity: Peripheral
 *
 */
@Entity
@Table (name = "PERIPHERAL")
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class Peripheral extends Product {

	private static final long serialVersionUID = 1L;

}
