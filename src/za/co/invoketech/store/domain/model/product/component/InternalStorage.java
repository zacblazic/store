package za.co.invoketech.store.domain.model.product.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * Entity implementation class for Entity: InternalStorage
 *
 */
@Entity
@Table (name = "INTERNAL_STORAGE")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class InternalStorage extends Component {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CAPACITY")
	private String capacity;
	
	@Column(name = "FORM_FACTOR")
	private String formFactor;	
	
	@Column(name = "BUS")
	private String bus;	
	
	@Column(name = "CACHE")
	private int cache;

	public String getCapacity() {
		return this.capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}   
	public String getFormFactor() {
		return this.formFactor;
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}   
	public String getBus() {
		return this.bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}   
	public int getCache() {
		return this.cache;
	}

	public void setCache(int cache) {
		this.cache = cache;
	}
}
