package za.co.invoketech.store.model.entity.product.software;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: OperatingSystem
 *
 */
@Entity
@Table (name = "OPERATING_SYSTEM")
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class OperatingSystem extends Software {

	private static final long serialVersionUID = 1L;
	
	private String platform;
	private String architechture;
	private int licences;

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}   
	public String getArchitechture() {
		return this.architechture;
	}

	public void setArchitechture(String architechture) {
		this.architechture = architechture;
	}   
	public int getLicences() {
		return this.licences;
	}

	public void setLicences(int licences) {
		this.licences = licences;
	}
   
}
