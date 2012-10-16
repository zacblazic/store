package za.co.invoketech.store.model.entity.product.component.value;

import javax.persistence.Embeddable;

@Embeddable
public class IntegratedGPU {
	private String name;
	private float baseClock;
	private float boostClock;
	private int displays;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBaseClock() {
		return baseClock;
	}
	public void setBaseClock(float baseClock) {
		this.baseClock = baseClock;
	}
	public float getBoostClock() {
		return boostClock;
	}
	public void setBoostClock(float boostClock) {
		this.boostClock = boostClock;
	}
	public int getDisplays() {
		return displays;
	}
	public void setDisplays(int displays) {
		this.displays = displays;
	}
	
	
}
