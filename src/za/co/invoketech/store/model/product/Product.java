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
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PRODUCT_TYPE", discriminatorType=DiscriminatorType.STRING)
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "PRODUCT_ID")
	private long id;
	
	private String productCode;
	private String description;
	private BigDecimal price;
	private boolean discontinued;
	private static final long serialVersionUID = 1L;

	public Product() 
	{
		super();
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