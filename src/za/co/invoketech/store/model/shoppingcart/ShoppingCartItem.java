package za.co.invoketech.store.model.shoppingcart;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import za.co.invoketech.store.model.product.Product;

@Entity
@Table(name = "SHOPPING_CART_ITEM")
public class ShoppingCartItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_QUANTITY = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SHOPPING_CART_ITEM_ID")
	private long shoppingCartItemId;
	
	@OneToOne
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;
	
	@Column(name = "QUANTITY")
	private int quantity;

	public ShoppingCartItem() {
		
	}
	
	public ShoppingCartItem(Product product) {
		this(product, DEFAULT_QUANTITY);
	}
	
	public ShoppingCartItem(Product product, int quantity) {
		this.product = new Product(product);
		this.quantity = quantity;
	}
	
	public ShoppingCartItem(ShoppingCartItem item) {
		this.shoppingCartItemId = item.shoppingCartItemId;
		this.product = new Product(item.product);
		this.quantity = item.quantity;
	}
	
	public long getShoppingCartItemId() {
		return shoppingCartItemId;
	}

	public void setShoppingCartItemId(long shoppingCartItemId) {
		this.shoppingCartItemId = shoppingCartItemId;
	}

	public Product getProduct() {
		return new Product(product);
	}

	public void setProduct(Product product) {
		this.product = new Product(product);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity <= 0) {
			throw new IllegalArgumentException("Quantity must be  > 0");
		}
		
		this.quantity = quantity;
	}
}
