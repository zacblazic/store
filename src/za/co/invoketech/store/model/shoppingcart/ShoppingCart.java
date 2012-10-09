package za.co.invoketech.store.model.shoppingcart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void addItem(ShoppingCartItem item) {	
		itemList.add(new ShoppingCartItem(item));
	}
	
	public void removeItem(ShoppingCartItem item) {
		itemList.remove(item);
	}
	
	public void removeItem(long itemId) {
		Iterator<ShoppingCartItem> iterator = itemList.iterator();
		
		while(iterator.hasNext()) {
			ShoppingCartItem item = iterator.next();
			
			if(item.getId() == itemId) {
				iterator.remove();
				break;
			}
		}
	}
	
	public List<ShoppingCartItem> getItems() {
		List<ShoppingCartItem> resultList = new ArrayList<ShoppingCartItem>();
		
		for(ShoppingCartItem item : itemList) {
			resultList.add(new ShoppingCartItem(item));
		}
		
		return resultList;
	}
	
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
