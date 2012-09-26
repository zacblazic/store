package za.co.invoketech.store.model.productsystem.software;

import java.io.Serializable;
import javax.persistence.*;

import za.co.invoketech.store.model.productsystem.software.Software;

/**
 * Entity implementation class for Entity: AntiVirus
 *
 */
@Entity
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class AntiVirus extends Software implements Serializable {

	
	private int licences;
	private static final long serialVersionUID = 1L;

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
