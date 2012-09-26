package za.co.invoketech.store.model.product.software;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Entity implementation class for Entity: AntiVirus
 *
 */
@Entity
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class AntiVirus extends Software implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int licences;

	public AntiVirus() {
		super();
	}   
	public int getLicences() {
		return this.licences;
	}

	public void setLicences(int licences) {
		this.licences = licences;
	}
   
}
