package za.co.invoketech.store.model.shoppingcart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SHOPPING_CART_ID")
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SHOPPING_CART_ID", nullable = false)
	private List<ShoppingCartItem> itemList;
	
	@Column(name = "DELETED")
	private boolean deleted;
	
	public ShoppingCart() {
		
	}

	public static ShoppingCart getInstance() {
		ShoppingCart cart = new ShoppingCart();
		cart.itemList = new ArrayList<ShoppingCartItem>();
		
		return cart;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void addItem(ShoppingCartItem item) {	
		itemList.add(item);
	}
	
	public void removeItem(ShoppingCartItem item) {
		itemList.remove(item);
	}
	
	public void removeAllItems() {
		// Used instead of clear to remove unused memory
		itemList = new ArrayList<ShoppingCartItem>();
	}
	
	public List<ShoppingCartItem> getItems() { 
		return itemList;
	}
	
	// TODO: Should we allow setItems()?
	
	public int getItemCount() {
		return itemList.size();
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
