package za.co.invoketech.store.service.cart;

import za.co.invoketech.store.domain.model.cart.ShoppingCartItem;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.model.product.Product;

public interface ShoppingCartService {
	public void addToCustomerCart (Customer customer, ShoppingCartItem item);
	public void addToCustomerCart (Customer customer, Product product, int quantity);
}
