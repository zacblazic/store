package za.co.invoketech.store.domain.model.product.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: GraphicsCard
 *
 */
@Entity
@Table (name = "GRAPHICS_CARD")
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class GraphicsCard extends Component {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CONNECTION_INTERFACE")
	private String connectionInterface;
	
	@Column(name = "MEMORY_TYPE")
	private String memoryType;
	
	@Column(name = "MEMORY_SIZE")
	private String memorySize;
	
	@Column(name = "MEMORY_INTERFACE")
	private String memoryInterface;
	
	@Column(name = "CORE_CLOCK_SPEED")
	private String coreClockSpeed;
	
	@Column(name = "MEMORY_CLOCK_SPEED")
	private String memoryClockSpeed;
	
	@Column(name = "OUTPUTS")
	private String outputs;
	
	@Column(name = "MAX_RESOLUTION")
	private String maxResolution;
	
	@Column(name = "DX_VERSION")
	private String dxVersion;
	
	@Column(name = "MULTI_GPU_SUPPORT")
	private String multiGpuSupport;
   
	public String getConnectionInterface() {
		return this.connectionInterface;
	}

	public void setConnectionInterface(String connectionInterface) {
		this.connectionInterface = connectionInterface;
	}   
	public String getMemoryType() {
		return this.memoryType;
	}

	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}   
	public String getMemorySize() {
		return this.memorySize;
	}

	public void setMemorySize(String memorySize) {
		this.memorySize = memorySize;
	}   
	public String getMemoryInterface() {
		return this.memoryInterface;
	}

	public void setMemoryInterface(String memoryInterface) {
		this.memoryInterface = memoryInterface;
	}   
	public String getCoreClockSpeed() {
		return this.coreClockSpeed;
	}

	public void setCoreClockSpeed(String coreClockSpeed) {
		this.coreClockSpeed = coreClockSpeed;
	}   
	public String getMemoryClockSpeed() {
		return this.memoryClockSpeed;
	}

	public void setMemoryClockSpeed(String memoryClockSpeed) {
		this.memoryClockSpeed = memoryClockSpeed;
	}   
	public String getOutputs() {
		return this.outputs;
	}

	public void setOutputs(String outputs) {
		this.outputs = outputs;
	}   
	public String getMaxResolution() {
		return this.maxResolution;
	}

	public void setMaxResolution(String maxResolution) {
		this.maxResolution = maxResolution;
	}   
	public String getDxVersion() {
		return this.dxVersion;
	}

	public void setDxVersion(String dxVersion) {
		this.dxVersion = dxVersion;
	}   
	public String getMultiGpuSupport() {
		return this.multiGpuSupport;
	}

	public void setMultiGpuSupport(String multiGpuSupport) {
		this.multiGpuSupport = multiGpuSupport;
	}
}
