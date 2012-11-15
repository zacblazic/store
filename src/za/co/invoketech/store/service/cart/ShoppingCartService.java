package za.co.invoketech.store.service.cart;

import java.util.List;

import za.co.invoketech.store.application.exception.CustomerNotFoundException;
import za.co.invoketech.store.application.exception.InvalidStockException;
import za.co.invoketech.store.application.exception.ProductNotFoundException;
import za.co.invoketech.store.application.exception.ShoppingCartItemNotFoundException;
import za.co.invoketech.store.domain.model.cart.ShoppingCart;
import za.co.invoketech.store.domain.model.cart.ShoppingCartItem;
import za.co.invoketech.store.domain.model.order.DeliveryMethod;
import za.co.invoketech.store.domain.model.order.Payment;

public interface ShoppingCartService {
	public ShoppingCart customerCart (long customerId) throws CustomerNotFoundException;
	public List<ShoppingCartItem> customerCartItems (long customerId) throws CustomerNotFoundException;
	public void addToCustomerCart (long customerId, ShoppingCartItem item) throws InvalidStockException, ProductNotFoundException, CustomerNotFoundException;
	public void addToCustomerCart (long customerId, long productId, int quantity) throws InvalidStockException, ProductNotFoundException, CustomerNotFoundException;
	public void updateQuantity(long customerId, long shoppingCartItemId, int quantity) 
			throws ShoppingCartItemNotFoundException, CustomerNotFoundException, InvalidStockException, ProductNotFoundException;
	public void checkout(long customerId, long addressId, Payment payment, DeliveryMethod method) throws CustomerNotFoundException;
}
