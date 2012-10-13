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
	private long id;
	
	@Column (name = "BRAND_NAME", unique = true)
	private String brandName; 

	public Brand (){		
	}
	
	public Brand (String brandName){
		setBrandName(brandName);
	}
  
	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	} 
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
   
}
