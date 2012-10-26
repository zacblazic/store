package za.co.invoketech.store.domain.model.product.software;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: AntiVirus
 *
 */
@Entity
@Table (name = "ANTIVIRUS")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class AntiVirus extends Software {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "LICENCES")
	private int licences;
	
	public int getLicences() {
		return this.licences;
	}

	public void setLicences(int licences) {
		this.licences = licences;
	}
}
