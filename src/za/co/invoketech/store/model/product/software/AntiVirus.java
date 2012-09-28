package za.co.invoketech.store.model.product.software;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: AntiVirus
 *
 */
@Entity
@Table (name = "ANTIVIRUS")
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class AntiVirus extends Software {

	private static final long serialVersionUID = 1L;
	
	private int licences;
	
	public int getLicences() {
		return this.licences;
	}

	public void setLicences(int licences) {
		this.licences = licences;
	}
   
}
