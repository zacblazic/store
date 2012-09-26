package za.co.invoketech.store.model.product.peripheral;

import java.io.Serializable;
import javax.persistence.*;

import za.co.invoketech.store.model.product.peripheral.Peripheral;

/**
 * Entity implementation class for Entity: Mouse
 *
 */
@Entity
@PrimaryKeyJoinColumn (name = "PRODUCT_ID")
public class Mouse extends Peripheral implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int dpi;
	private int buttons;

	public Mouse() {
		super();
	}   
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
