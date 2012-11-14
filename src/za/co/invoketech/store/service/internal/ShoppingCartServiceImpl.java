package za.co.invoketech.store.service.internal;

import za.co.invoketech.store.application.exception.CustomerNotFoundException;
import za.co.invoketech.store.application.exception.InvalidStockException;
import za.co.invoketech.store.application.exception.ProductNotFoundException;
import za.co.invoketech.store.application.exception.ShoppingCartItemNotFoundException;
import za.co.invoketech.store.domain.model.cart.ShoppingCart;
import za.co.invoketech.store.domain.model.cart.ShoppingCartItem;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.model.product.Product;
import za.co.invoketech.store.service.cart.ShoppingCartService;
import za.co.invoketech.store.service.customer.CustomerService;
import za.co.invoketech.store.service.product.ProductService;

import com.google.inject.Inject;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Inject
	private ProductService productService;
	
	@Inject
	private CustomerService customerService;

	@Override
	public void addToCustomerCart(long customerId, ShoppingCartItem item) throws InvalidStockException, ProductNotFoundException, CustomerNotFoundException {
		Customer customer = null;
		
		if (item.getQuantity() <= 0) {
			throw new InvalidStockException("Quantity Cannot be less than 0");
		}
		
		if (item.getProduct() == null || item.getProduct().getId() == 0) {
			throw new ProductNotFoundException();
		}
		
		if (item.getProduct().getStock() <= item.getQuantity()) {
			throw new InvalidStockException("Not Enough Stock");
		}
		
		customer = customerService.findCustomerById(customerId);
		
		ShoppingCart cart = customer.getShoppingCart();
		cart.addItem(item);
		customer.setShoppingCart(cart);
		
		customerService.updateCustomer(customer);
	}

	@Override
	public void addToCustomerCart(long customerId, long productId,	int quantity) throws InvalidStockException, ProductNotFoundException, CustomerNotFoundException {
		Product product = productService.getProduct(productId);
		
		ShoppingCartItem item = new ShoppingCartItem(product, quantity);
		addToCustomerCart(customerId, item);
	}

	@Override
	public void updateQuantity(long customerId, long shoppingCartItemId, int quantity) 
			throws ShoppingCartItemNotFoundException, CustomerNotFoundException, InvalidStockException, ProductNotFoundException {
		if (shoppingCartItemId > 0) {
			Customer customer = customerService.findCustomerById(customerId);
			boolean found = false;
			ShoppingCartItem foundItem = null;
			
			ShoppingCart cart = customer.getShoppingCart();
			for (ShoppingCartItem item : cart.getItems()) {
				if (item.getId() == shoppingCartItemId) {
					found = true;
					foundItem = item;
					break;
				}
			}
			
			if (found) {
				cart = customer.getShoppingCart();
				cart.removeItem(foundItem);
				foundItem.setQuantity(quantity);
				addToCustomerCart(customerId, foundItem);
			}
			else throw new ShoppingCartItemNotFoundException();
		}
		else throw new ShoppingCartItemNotFoundException();
	}

	@Override
	public void checkout(long customerId, long addressId) {
		// TODO Auto-generated method stub
		
	}

}
