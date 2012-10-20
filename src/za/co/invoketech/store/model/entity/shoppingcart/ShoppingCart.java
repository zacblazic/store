package za.co.invoketech.store.model.entity.shoppingcart;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

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
	private List<ShoppingCartItem> items;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public ShoppingCart() {}
	
	// TODO: Maybe allow the use of default constructor, if testing passes
	
	public ShoppingCart(List<ShoppingCartItem> items) {
		checkItems(items);
		this.items = copyItems(items);
	}
	
	public ShoppingCart(ShoppingCart cart) {
		this.id = cart.id;
		this.items = copyItems(items);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void addItem(ShoppingCartItem item) {
		checkItem(item);
		items.add(new ShoppingCartItem(item));
	}
	
	public void removeItem(ShoppingCartItem item) {
		items.remove(item);
	}
	
	public boolean hasItem(ShoppingCartItem item) {
		return items.contains(item);
	}
	
	public void removeAllItems() {
		items = new ArrayList<ShoppingCartItem>();
	}
	
	public List<ShoppingCartItem> getItems() {
		return copyItems(items);
	}
	
	public void setItems(List<ShoppingCartItem> items) {
		checkItems(items);
		this.items = copyItems(items);
	}
	
	public int getItemCount() {
		return items.size();
	}
	
	private void checkItem(ShoppingCartItem item) {
		checkNotNull(item, "item cannot be null");
	}
	
	private void checkItems(List<ShoppingCartItem> items) {
		checkNotNull(items, "items cannot be null");
		checkArgument(!items.contains(null), "items cannot contain nulls");
	}
	
	private List<ShoppingCartItem> copyItems(List<ShoppingCartItem> items) {
		List<ShoppingCartItem> copiedItems = new ArrayList<ShoppingCartItem>();
		
		for(ShoppingCartItem item : items) {
			copiedItems.add(new ShoppingCartItem(item));
		}
		
		return copiedItems;
	}
}
