package za.co.invoketech.store.model.product;

import java.io.Serializable;
import java.lang.String;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@Table (name = "PRODUCT")
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PRODUCT_TYPE", discriminatorType=DiscriminatorType.STRING)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "PRODUCT_ID")
	private long id;
	
	@Column (unique = true)
	private String productCode;
	
	private String description;
	private BigDecimal price;
	private boolean discontinued;
	
	public Product() {
	}
	
	public Product(Product product) {
		this.id = product.id;
		this.productCode = product.productCode;
		this.price = product.price;
		this.discontinued = product.discontinued;
	}

	public long getId() 
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getProductCode() 
	{
		return this.productCode;
	}

	public void setProductCode(String productCode) 
	{
		this.productCode = productCode;
	}   
	
	public String getDescription() 
	{
		return this.description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}   
	
	public BigDecimal getPrice()
	{
		return this.price;
	}

	public void setPrice(BigDecimal price) 
	{
		this.price = price;
	}   
	
	public boolean getDiscontinued() 
	{
		return this.discontinued;
	}

	public void setDiscontinued(boolean discontinued) 
	{
		this.discontinued = discontinued;
	}
   
}
