package za.co.invoketech.store.domain.model.product.component;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import za.co.invoketech.store.domain.model.product.Product;

/**
 * Entity implementation class for Entity: Component
 *
 */
@Entity
@Table(name = "COMPONENT")
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class Component extends Product {

	private static final long serialVersionUID = 1L;

}
