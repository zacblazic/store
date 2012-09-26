package za.co.invoketech.store.model.product.software;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

import za.co.invoketech.store.model.product.Product;

/**
 * Entity implementation class for Entity: Software
 *
 */
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class Software extends Product implements Serializable {

	private static final long serialVersionUID = 1L;
		
	private String developer;

	public Software() {
		super();
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}
   
	
}
