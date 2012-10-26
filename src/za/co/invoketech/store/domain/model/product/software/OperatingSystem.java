package za.co.invoketech.store.domain.model.product.software;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: OperatingSystem
 *
 */
@Entity
@Table(name = "OPERATING_SYSTEM")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class OperatingSystem extends Software {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "PLATFORM")
	private String platform;
	
	@Column(name = "ARCHITECTURE")
	private String architecture;
	
	@Column(name = "LICENCES")
	private int licences;

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}   
	
	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public int getLicences() {
		return this.licences;
	}

	public void setLicences(int licences) {
		this.licences = licences;
	}
}
