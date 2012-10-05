package za.co.invoketech.store.service.customer;

public interface ShoppingCartService {
	public void addToCart(Long productId);
	public void removeFromCart(Long shoppingCartItemId);
	public void updateCart();
	public void moveToWishlist();
	public void checkout();
}
