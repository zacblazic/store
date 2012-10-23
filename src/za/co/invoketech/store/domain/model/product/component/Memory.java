package za.co.invoketech.store.domain.model.product.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Memory
 *
 */
@Entity
@Table (name = "MEMORY")
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class Memory extends Component {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "MODULES")
	private int modules;
	@Column(name = "SIZE")
	private String size;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "VOLTAGE")
	private float voltage;
	@Column(name = "FREQUENCY")
	private String frequency;
	@Column(name = "LATENCY")
	private String latency;	


	public int getModules() {
		return this.modules;
	}

	public void setModules(int modules) {
		this.modules = modules;
	}   
	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public float getVoltage() {
		return this.voltage;
	}

	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}   
	public String getFrequency() {
		return this.frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}   
	public String getLatency() {
		return this.latency;
	}

	public void setLatency(String latency) {
		this.latency = latency;
	}
   
}
