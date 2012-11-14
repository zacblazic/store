package za.co.invoketech.store.service.cart;

import za.co.invoketech.store.application.exception.CustomerNotFoundException;
import za.co.invoketech.store.application.exception.InvalidStockException;
import za.co.invoketech.store.application.exception.ProductNotFoundException;
import za.co.invoketech.store.application.exception.ShoppingCartItemNotFoundException;
import za.co.invoketech.store.domain.model.cart.ShoppingCartItem;

public interface ShoppingCartService {
	public void addToCustomerCart (long customerId, ShoppingCartItem item) throws InvalidStockException, ProductNotFoundException, CustomerNotFoundException;
	public void addToCustomerCart (long customerId, long productId, int quantity) throws InvalidStockException, ProductNotFoundException, CustomerNotFoundException;
	public void updateQuantity(long customerId, long shoppingCartItemId, int quantity) 
			throws ShoppingCartItemNotFoundException, CustomerNotFoundException, InvalidStockException, ProductNotFoundException;
	public void checkout(long customerId, long addressId);
}
