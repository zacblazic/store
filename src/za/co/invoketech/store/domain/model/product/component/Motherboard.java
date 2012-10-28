package za.co.invoketech.store.domain.model.product.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * Entity implementation class for Entity: Motherboard
 *
 */
@Entity
@Table (name = "MOTHERBOARD")
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class Motherboard extends Component {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "CHIPSET")
	private String chipset;
	
	@Column(name = "SOCKET")
	private String socket;
	
	@Column(name = "MEMORY_TYPE")
	private String memoryType;
	
	@Column(name = "MEMORY_CHANNEL")
	private String memoryChannel;
	
	@Column(name = "MEMORY_SLOTS")
	private String memorySlots;
	
	@Column(name = "MAX_MEMORY")
	private int maxMemory;
	
	@Column(name = "PCIE")
	private int pcie;
	
	@Column(name = "PCI")
	private int pci;
	
	@Column(name = "IDE")
	private int ide;
	
	@Column(name = "SATA3")
	private int sata3;
	
	@Column(name = "SATA2")
	private int sata2;
	
	@Column(name = "LAN")
	private String lan;
	
	@Column(name = "USB3")
	private int usb3;
	
	@Column(name = "USB2")
	private int usb2;
	
	@Column(name = "AUDIO_PORTS")
	private int audioPorts;
	
	@Column(name = "FIREWIRE")
	private int firewire;
	
	@Column(name = "ESATA")
	private int esata;
	
	@Column(name = "VGA")
	private int vga;
	
	@Column(name = "DVI")
	private int dvi;
	
	@Column(name = "HDMI")
	private int hdmi;
	
	@Column(name = "FORM_FACTOR")
	private String formFactor;
	
	@Column(name = "SLI_CROSSFIRE")
	private boolean sliCrossfire;

	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getMemoryType() {
		return memoryType;
	}

	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}

	public String getMemoryChannel() {
		return memoryChannel;
	}

	public void setMemoryChannel(String memoryChannel) {
		this.memoryChannel = memoryChannel;
	}

	public String getMemorySlots() {
		return memorySlots;
	}

	public void setMemorySlots(String memorySlots) {
		this.memorySlots = memorySlots;
	}

	public int getMaxMemory() {
		return maxMemory;
	}

	public void setMaxMemory(int maxMemory) {
		this.maxMemory = maxMemory;
	}

	public int getPcie() {
		return pcie;
	}

	public void setPcie(int pcie) {
		this.pcie = pcie;
	}

	public int getPci() {
		return pci;
	}

	public void setPci(int pci) {
		this.pci = pci;
	}

	public int getIde() {
		return ide;
	}

	public void setIde(int ide) {
		this.ide = ide;
	}

	public int getSata3() {
		return sata3;
	}

	public void setSata3(int sata3) {
		this.sata3 = sata3;
	}

	public int getSata2() {
		return sata2;
	}

	public void setSata2(int sata2) {
		this.sata2 = sata2;
	}

	public String getLan() {
		return lan;
	}

	public void setLan(String lan) {
		this.lan = lan;
	}

	public int getUsb3() {
		return usb3;
	}

	public void setUsb3(int usb3) {
		this.usb3 = usb3;
	}

	public int getUsb2() {
		return usb2;
	}

	public void setUsb2(int usb2) {
		this.usb2 = usb2;
	}

	public int getAudioPorts() {
		return audioPorts;
	}

	public void setAudioPorts(int audioPorts) {
		this.audioPorts = audioPorts;
	}

	public int getFirewire() {
		return firewire;
	}

	public void setFirewire(int firewire) {
		this.firewire = firewire;
	}

	public int getEsata() {
		return esata;
	}

	public void setEsata(int esata) {
		this.esata = esata;
	}

	public int getVga() {
		return vga;
	}

	public void setVga(int vga) {
		this.vga = vga;
	}

	public int getDvi() {
		return dvi;
	}

	public void setDvi(int dvi) {
		this.dvi = dvi;
	}

	public int getHdmi() {
		return hdmi;
	}

	public void setHdmi(int hdmi) {
		this.hdmi = hdmi;
	}

	public String getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}

	public boolean isSliCrossfire() {
		return sliCrossfire;
	}

	public void setSliCrossfire(boolean sliCrossfire) {
		this.sliCrossfire = sliCrossfire;
	}
}
