package za.co.invoketech.store.presentation.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.product.Product;

@SessionScoped
@ManagedBean
public class ShoppingCartBean {

	private List<ShoppingCartItemBean> shoppingCartItemBeans;
	
	public ShoppingCartBean() {
		Goose.guicify(this);
		
		// Initialize the items
		shoppingCartItemBeans = new ArrayList<ShoppingCartItemBean>();
	}

	public List<ShoppingCartItemBean> getShoppingCartItemBeans() {
		return shoppingCartItemBeans;
	}
	
	public void setShoppingCartItemBeans(
			List<ShoppingCartItemBean> shoppingCartItemBeans) {
		this.shoppingCartItemBeans = shoppingCartItemBeans;
	}
	
	public boolean containsProduct(long productId) {
		for(ShoppingCartItemBean shoppingCartItemBean : shoppingCartItemBeans) {
			Product product = shoppingCartItemBean.getShoppingCartItem().getProduct();
			
			if(productId == product.getId()) {
				return true;
			}
		}
		return false;
	}
	
	public ShoppingCartItemBean getShoppingCartItemBeanByProductId(long productId) {
		for(ShoppingCartItemBean shoppingCartItemBean : shoppingCartItemBeans) {
			Product product = shoppingCartItemBean.getShoppingCartItem().getProduct();
			
			if(productId == product.getId()) {
				return shoppingCartItemBean;
			}
		}
		return null;
	}
	
	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0);
		
		for(ShoppingCartItemBean item : shoppingCartItemBeans) {
			total = total.add(item.getShoppingCartItem().getSubTotal());
		}
		
		return total;
	}
}