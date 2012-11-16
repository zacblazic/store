package za.co.invoketech.store.presentation.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.shiro.SecurityUtils;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.CustomerNotLinkedException;
import za.co.invoketech.store.domain.model.cart.ShoppingCart;
import za.co.invoketech.store.domain.model.cart.ShoppingCartItem;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.model.order.DeliveryMethod;
import za.co.invoketech.store.domain.model.order.Payment;
import za.co.invoketech.store.domain.model.order.PaymentMethod;
import za.co.invoketech.store.domain.model.product.Product;
import za.co.invoketech.store.presentation.model.ShoppingCartBean;
import za.co.invoketech.store.presentation.model.ShoppingCartItemBean;
import za.co.invoketech.store.service.cart.ShoppingCartService;
import za.co.invoketech.store.service.customer.CustomerService;
import za.co.invoketech.store.service.product.ProductService;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

@RequestScoped
@ManagedBean
public class ShoppingCartController {

	@Inject private ProductService productService;
	@Inject private CustomerService customerService;
	@Inject private ShoppingCartService shoppingCartService;
	
	@ManagedProperty(value="#{shoppingCartBean}")
	private ShoppingCartBean shoppingCartBean;
	
	private boolean selectAll = false;
	
	public ShoppingCartController() {
		Goose.guicify(this);
	}

	public ShoppingCartBean getShoppingCartBean() {
		return shoppingCartBean;
	}

	public void setShoppingCartBean(ShoppingCartBean shoppingCartBean) {
		this.shoppingCartBean = shoppingCartBean;
	}
	
	public boolean isSelectAll() {
		return selectAll;
	}

	public void setSelectAll(boolean selectAll) {
		this.selectAll = selectAll;
	}
	
	public void toggleSelectAll() {
		System.out.print("TEST");
		
		List<ShoppingCartItemBean> items = shoppingCartBean.getShoppingCartItemBeans();
		
		if(isSelectAll()) {
			for(ShoppingCartItemBean item : items) {
				item.setSelected(true);
			}
		} else {
			for(ShoppingCartItemBean item : items) {
				item.setSelected(false);
			}
		}
	}

	public String addItem(long productId) {
		if(!isAuthenticated()) {
			return "/login?faces-redirect=true";
		}
		
		if(shoppingCartBean.containsProduct(productId)) {
			System.out.println("Updating existing");
			shoppingCartBean.getShoppingCartItemBeanByProductId(productId).getShoppingCartItem().increaseQuantity(1);
		} else {
			System.out.println("Adding new");
			Product product = productService.findProductById(productId);
			ShoppingCartItem shoppingCartItem = new ShoppingCartItem(product);
			ShoppingCartItemBean shoppingCartItemBean = new ShoppingCartItemBean(shoppingCartItem, false);
			shoppingCartBean.getShoppingCartItemBeans().add(shoppingCartItemBean);
		}
		
		saveCart();
		
		return "";
	}
	
	public void removeItems() {
		List<ShoppingCartItemBean> items = shoppingCartBean.getShoppingCartItemBeans();
		
		Iterator<ShoppingCartItemBean> iterator = items.iterator();
		while(iterator.hasNext()) {
			ShoppingCartItemBean item = iterator.next();
			
			if(item.isSelected()) {
				iterator.remove();
			}
		}
		
		saveCart();
	}
	
	public void updateQuantities() {
		String email = (String)SecurityUtils.getSubject().getPrincipal();
		Customer customer = null;
		
		try {
			customer = customerService.findCustomerByEmail(email);
		} catch (AccountNotFoundException | CustomerNotLinkedException e) {
			e.printStackTrace();
		}
		
		if(customer != null) {
			ShoppingCart cart = new ShoppingCart(new ArrayList<ShoppingCartItem>());
			List<ShoppingCartItemBean> items = shoppingCartBean.getShoppingCartItemBeans();
			
			for(ShoppingCartItemBean item : items) {
				cart.addItem(item.getShoppingCartItem());
			}
			
			customer.setShoppingCart(cart);
			customerService.updateCustomer(customer);
		}
	}
	
	public void loadCart() {
		String email = (String)SecurityUtils.getSubject().getPrincipal();
		Customer customer = null;
		
		try {
			customer = customerService.findCustomerByEmail(email);
		} catch (AccountNotFoundException | CustomerNotLinkedException e) {
			e.printStackTrace();
		}
		
		if(customer != null) {
			List<ShoppingCartItem> items = customer.getShoppingCart().getItems();
			
			for(ShoppingCartItem item : items) {
				shoppingCartBean.getShoppingCartItemBeans().add(new ShoppingCartItemBean(item, false));
			}
			
			System.out.println("Cart loaded." + shoppingCartBean.getShoppingCartItemBeans().size() + " items in cart.");
		}
	}
	
	public void saveCart() {
		String email = (String)SecurityUtils.getSubject().getPrincipal();
		Customer customer = null;
		
		try {
			customer = customerService.findCustomerByEmail(email);
		} catch (AccountNotFoundException | CustomerNotLinkedException e) {
			e.printStackTrace();
		}
		
		if(customer != null) {
			ShoppingCart cart = new ShoppingCart(new ArrayList<ShoppingCartItem>());
			List<ShoppingCartItemBean> items = shoppingCartBean.getShoppingCartItemBeans();
			
			for(ShoppingCartItemBean item : items) {
				cart.addItem(item.getShoppingCartItem());
			}
			
			customer.setShoppingCart(cart);
			customerService.updateCustomer(customer);
		}
	}
	
	public boolean isAuthenticated() {
		return SecurityUtils.getSubject().isAuthenticated();
	}
	
	public void checkout() {
		String email = (String)SecurityUtils.getSubject().getPrincipal();
		Customer customer = null;
		
		try {
			customer = customerService.findCustomerByEmail(email);
		} catch (AccountNotFoundException | CustomerNotLinkedException e) {
			e.printStackTrace();
		}
		
		if(customer != null) {
			Address address = customer.getPrimaryAddress();
			Payment payment = new Payment(PaymentMethod.EFT);
			DeliveryMethod delMethod = DeliveryMethod.COLLECT;
			
			try {
				shoppingCartService.checkout(customer.getId(), address.getId(), payment, delMethod);
				ShoppingCartBean newBean = new ShoppingCartBean();
				newBean.setShoppingCartItemBeans(new ArrayList<ShoppingCartItemBean>());
				setShoppingCartBean(newBean);
				loadCart();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
