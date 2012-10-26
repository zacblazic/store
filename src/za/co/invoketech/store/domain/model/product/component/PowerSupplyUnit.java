package za.co.invoketech.store.domain.model.product.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: PowerSupplyUnit
 *
 */
@Entity
@Table (name = "POWER_SUPPLY_UNIT")
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class PowerSupplyUnit extends Component {

	private static final long serialVersionUID = 1L;

	@Column(name = "POWER")
	private String power;
	
	@Column(name = "MODULAR")
	private boolean modular;
	
	@Column(name = "ATX")
	private int atx;
	
	@Column(name = "EPS")
	private int eps;
	
	@Column(name = "PCIE")
	private int pcie;
	
	@Column(name = "MOLEX")
	private int molex;
	
	@Column(name = "SATA")
	private int sata;
	
	@Column(name = "FLOPPY")
	private int floppy;

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}   
	
	public boolean getModular() {
		return this.modular;
	}

	public void setModular(boolean modular) {
		this.modular = modular;
	}   
	
	public int getAtx() {
		return this.atx;
	}

	public void setAtx(int atx) {
		this.atx = atx;
	}   
	
	public int getEps() {
		return this.eps;
	}

	public void setEps(int eps) {
		this.eps = eps;
	}   
	
	public int getPcie() {
		return this.pcie;
	}

	public void setPcie(int pcie) {
		this.pcie = pcie;
	}   
	
	public int getMolex() {
		return this.molex;
	}

	public void setMolex(int molex) {
		this.molex = molex;
	}   
	
	public int getSata() {
		return this.sata;
	}

	public void setSata(int sata) {
		this.sata = sata;
	}   
	
	public int getFloppy() {
		return this.floppy;
	}

	public void setFloppy(int floppy) {
		this.floppy = floppy;
	}
}
