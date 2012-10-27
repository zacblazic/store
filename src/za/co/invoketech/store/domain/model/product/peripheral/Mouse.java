package za.co.invoketech.store.domain.model.product.peripheral;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Mouse
 *
 */
@Entity
@Table (name = "MOUSE")
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class Mouse extends Peripheral {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "DPI")
	private int dpi;
	
	@Column(name = "BUTTONS")
	private int buttons;
	
	public int getDpi() {
		return this.dpi;
	}

	public void setDpi(int dpi) {
		this.dpi = dpi;
	}   
	
	public int getButtons() {
		return this.buttons;
	}

	public void setButtons(int buttons) {
		this.buttons = buttons;
	}
}
