package za.co.invoketech.store.model.product.peripheral;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import za.co.invoketech.store.model.product.Brand;
import za.co.invoketech.store.model.product.Product;

/**
 * Entity implementation class for Entity: Peripheral
 *
 */
@Entity
@Table (name = "PERIPHERAL")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class Peripheral extends Product {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Brand brand;

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	} 
   
   
}
