/**
 * Copyright (c) 2012 Invoke Tech
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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

	public ShoppingCart(List<ShoppingCartItem> items) {
		checkItems(items);
		this.items = copyItems(items);
	}
	
	public ShoppingCart(ShoppingCart cart) {
		checkShoppingCart(cart);
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
		
		if(hasItem(item)) {
			getItem(item).increaseQuantity(item.getQuantity());
		} else {
			items.add(new ShoppingCartItem(item));
		}
	}
	
	public void removeItem(ShoppingCartItem item) {
		checkItem(item);
		items.remove(item);
	}
	
	public boolean hasItem(ShoppingCartItem item) {
		checkItem(item);
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
	
	public int getItemCountWithQuantity() {
		int count = 0;
		
		for(ShoppingCartItem item : items) {
			count += item.getQuantity();
		}
		
		return count;
	}
	
	private ShoppingCartItem getItem(ShoppingCartItem existingItem) {
		for(ShoppingCartItem item : items) {
			if(item.equals(existingItem)) {
				return item;
			}
		}
		
		return null;
	}
	
	private List<ShoppingCartItem> copyItems(List<ShoppingCartItem> items) {
		List<ShoppingCartItem> copiedItems = new ArrayList<ShoppingCartItem>();
		
		for(ShoppingCartItem item : items) {
			copiedItems.add(new ShoppingCartItem(item));
		}
		
		return copiedItems;
	}
	
	private void checkShoppingCart(ShoppingCart cart) {
		checkNotNull(cart, "cart cannot be null");
	}
	
	private void checkItem(ShoppingCartItem item) {
		checkNotNull(item, "item cannot be null");
	}
	
	private void checkItems(List<ShoppingCartItem> items) {
		checkNotNull(items, "items cannot be null");
		checkArgument(!items.contains(null), "items cannot contain nulls");
	}
}
