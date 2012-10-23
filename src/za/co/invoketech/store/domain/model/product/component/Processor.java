package za.co.invoketech.store.domain.model.product.component;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * Entity implementation class for Entity: Processor
 *
 */
@Entity
@Table (name = "PROCESSOR")
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class Processor extends Component {

	
	private static final long serialVersionUID = 1L;

	@Column(name = "FAMILY")
	private String family;
	@Column(name = "CLOCK_SPEED")
	private float clockSpeed;
	@Column(name = "BOOST_CLOCK")
	private float boostClock;
	@Column(name = "SOCKET")
	private String socket;
	@Column(name = "CACHE")
	private int cache;
	@Column(name = "CORES")
	private int cores;
	@Column(name = "THREADS")
	private int threads;
	@Embedded
	private IntegratedGPU integratedGPU = new IntegratedGPU();
	
	
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public float getClockSpeed() {
		return clockSpeed;
	}
	public void setClockSpeed(float clockSpeed) {
		this.clockSpeed = clockSpeed;
	}
	public float getBoostClock() {
		return boostClock;
	}
	public void setBoostClock(float boostClock) {
		this.boostClock = boostClock;
	}
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public int getCache() {
		return cache;
	}
	public void setCache(int cache) {
		this.cache = cache;
	}
	public int getCores() {
		return cores;
	}
	public void setCores(int cores) {
		this.cores = cores;
	}
	public int getThreads() {
		return threads;
	}
	public void setThreads(int threads) {
		this.threads = threads;
	}
	public IntegratedGPU getIntegratedGPU() {
		return integratedGPU;
	}
	public void setIntegratedGPU(IntegratedGPU integratedGPU) {
		this.integratedGPU = integratedGPU;
	}
	
    
	
}
