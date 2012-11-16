package za.co.invoketech.store.presentation.model;

import za.co.invoketech.store.domain.model.cart.ShoppingCartItem;

public class ShoppingCartItemBean {

	private ShoppingCartItem shoppingCartItem;
	private boolean selected;
	
	public ShoppingCartItemBean() {}
	
	public ShoppingCartItemBean(ShoppingCartItem shoppingCartItem, boolean selected) {
		this.shoppingCartItem = shoppingCartItem;
		this.selected = selected;
	}
	
	public ShoppingCartItem getShoppingCartItem() {
		return shoppingCartItem;
	}

	public void setShoppingCartItem(ShoppingCartItem shoppingCartItem) {
		this.shoppingCartItem = shoppingCartItem;
	}

	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof ShoppingCartItemBean)) {
			return false;
		}
		
		ShoppingCartItemBean other = (ShoppingCartItemBean)object;
		if(!this.getShoppingCartItem().getProduct().equals(other.getShoppingCartItem().getProduct())) {
			return false;
		}
		return true;
	}
}
