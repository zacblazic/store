package za.co.invoketech.store.service.internal;

import za.co.invoketech.store.domain.model.cart.ShoppingCartItem;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.model.order.DeliveryAddress;
import za.co.invoketech.store.domain.model.product.Product;
import za.co.invoketech.store.service.cart.ShoppingCartService;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Override
	public void addToCustomerCart(Customer customer, ShoppingCartItem item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addToCustomerCart(Customer customer, Product product,
			int quantity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkout(Customer customer, DeliveryAddress address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateQuantity(ShoppingCartItem shoppingCartItem, int quantity) {
		// TODO Auto-generated method stub
		
	}

}
