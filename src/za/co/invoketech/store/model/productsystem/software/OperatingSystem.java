package za.co.invoketech.store.model.productsystem.software;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import za.co.invoketech.store.model.productsystem.software.Software;

/**
 * Entity implementation class for Entity: OperatingSystem
 *
 */
@Entity
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class OperatingSystem extends Software implements Serializable {

	private String platform;
	private String architechture;
	private int licences;
	private static final long serialVersionUID = 1L;

	public OperatingSystem() {
		super();
	}   
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
