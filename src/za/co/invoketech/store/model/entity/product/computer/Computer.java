package za.co.invoketech.store.model.entity.product.computer;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import za.co.invoketech.store.model.entity.product.Product;

/**
 * Entity implementation class for Entity: Computer
 *
 */
@Entity
@Table (name = "COMPUTER")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class Computer extends Product {

	private static final long serialVersionUID = 1L;

   
}
