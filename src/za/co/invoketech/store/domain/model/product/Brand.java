package za.co.invoketech.store.domain.model.product;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * Entity implementation class for Entity: Brand
 *
 */
@Entity
@Table (name = "BRAND")
public class Brand implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column (name = "BRAND_NAME", unique = true)
	@Expose
	private String brandName; 
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public Brand() {}
	
	public Brand (String brandName){
		checkBrandName(brandName);
		this.brandName = brandName;
	}
	
	public long getId() {
		return this.id;
	}
  
	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		checkBrandName(brandName);
		this.brandName = brandName;
	} 
	
	public String toString() {
		return brandName;
	}
	
	private void checkBrandName(String brandName) {
		checkNotNull(brandName, "brandName cannot be null");
		checkArgument(!brandName.isEmpty(), "brandName cannot be empty");
	} 
}
