package za.co.invoketech.store.domain.model.product.computer;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import za.co.invoketech.store.domain.model.product.Product;

/**
 * Entity implementation class for Entity: Computer
 *
 */
@Entity
@Table (name = "COMPUTER")
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class Computer extends Product {

	private static final long serialVersionUID = 1L;
   
}
