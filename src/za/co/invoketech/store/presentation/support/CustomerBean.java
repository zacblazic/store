package za.co.invoketech.store.presentation.support;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.shiro.SecurityUtils;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.CustomerNotLinkedException;
import za.co.invoketech.store.presentation.controller.ShoppingCartController;
import za.co.invoketech.store.service.customer.CustomerService;

import com.google.inject.Inject;

@SessionScoped
@ManagedBean
public class CustomerBean {

	@Inject
	private CustomerService customerService;
	
	private long customerId;
	
	@ManagedProperty(value = "#{shoppingCartController}")
	private ShoppingCartController shoppingCartController;
	
	public CustomerBean() {
		Goose.guicify(this);
	}

	public void load() {
		System.out.println("Loading customer...");
		
		loadCustomerId();
		loadShoppingCart();
		
		System.out.println("Customer Id: " + customerId);
	}
	
	public void loadCustomerId() {
		String email = (String)SecurityUtils.getSubject().getPrincipal();
		
		try {
			customerId = customerService.findCustomerIdByEmail(email);
		} catch (AccountNotFoundException | CustomerNotLinkedException e) {
			e.printStackTrace();
		}
	}
	
	public void loadShoppingCart()  {
		shoppingCartController.loadCart();
	}
	
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public ShoppingCartController getShoppingCartController() {
		return shoppingCartController;
	}

	public void setShoppingCartController(ShoppingCartController shoppingCartController) {
		this.shoppingCartController = shoppingCartController;
	}
}
