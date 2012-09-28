package za.co.invoketech.store.model.product;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Brand
 *
 */
@Entity
@Table (name = "BRAND")
public class Brand implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long brand_id;
	
	@Column (unique = true)
	private String brandName;  
  
	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}   
	public long getBrand_id() {
		return this.brand_id;
	}

	public void setBrand_id(long brand_id) {
		this.brand_id = brand_id;
	}
   
}
