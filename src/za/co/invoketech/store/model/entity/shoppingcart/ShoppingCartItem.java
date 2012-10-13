package za.co.invoketech.store.model.entity.shoppingcart;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import za.co.invoketech.store.model.entity.product.Product;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "SHOPPING_CART_ITEM")
public class ShoppingCartItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_QUANTITY = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SHOPPING_CART_ITEM_ID")
	private long id;
	
	@OneToOne
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "DELETED")
	private boolean deleted;
	
	public static ShoppingCartItem getInstance(Product product) {
		return getInstance(product, DEFAULT_QUANTITY);
	}
	
	public static ShoppingCartItem getInstance(Product product, int quantity) {
		if(quantity <= 0) {
			// TODO: Handle invalid quantity
		}
		
		ShoppingCartItem item = new ShoppingCartItem();
		item.product = product;
		item.quantity = quantity;
		
		return item;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity <= 0) {
			// TODO: Handle invalid quantity
		}
		
		this.quantity = quantity;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
