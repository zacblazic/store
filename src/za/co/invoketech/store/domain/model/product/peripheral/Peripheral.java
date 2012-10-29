package za.co.invoketech.store.domain.model.product.peripheral;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import za.co.invoketech.store.domain.model.product.Brand;
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

	@ManyToOne (cascade=CascadeType.PERSIST)
	@Expose
	private Brand brand;

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	} 
}
