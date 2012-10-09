package za.co.invoketech.store.service.customer.internal;

import com.google.inject.Inject;

import za.co.invoketech.store.service.customer.ShoppingCartService;
import za.co.invoketech.store.service.dao.CustomerDao;
import za.co.invoketech.store.service.dao.ProductDao;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Inject
	private CustomerDao customerDao;
	
	@Inject
	private ProductDao productDao;

	@Override
	public void addToCart(Long productId) {
		
	}

	@Override
	public void removeFromCart(Long shoppingCartItemId) {
		
	}

	@Override
	public void updateCart() {
		
	}

	@Override
	public void moveToWishlist() {
		
	}

	@Override
	public void checkout() {
		
	}

}
