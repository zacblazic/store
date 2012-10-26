package za.co.invoketech.store.domain.model.product.software;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import za.co.invoketech.store.domain.model.product.Product;

/**
 * Entity implementation class for Entity: Software
 *
 */
@Entity
@Table (name = "SOFTWARE")
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class Software extends Product {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "DEVELOPER", nullable = false)
	private String developer;

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}
}
