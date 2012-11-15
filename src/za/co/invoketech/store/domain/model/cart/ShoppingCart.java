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

package za.co.invoketech.store.domain.model.cart;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import za.co.invoketech.store.application.util.Dates;

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
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "SHOPPING_CART_ID")
	private List<ShoppingCartItem> items;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_DATE", nullable = false)
	private Date lastUpdatedDate;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public ShoppingCart() {}

	public ShoppingCart(List<ShoppingCartItem> items) {
		checkItems(items);
		this.items = ShoppingCartItem.copyAll(items);
		this.lastUpdatedDate = Dates.now();
	}
	
	private ShoppingCart(ShoppingCart cart) {
		this.id = cart.id;
		this.items = ShoppingCartItem.copyAll(cart.items);
		this.lastUpdatedDate = Dates.copy(cart.lastUpdatedDate);
	}
	
	public static ShoppingCart copy(ShoppingCart cart) {
		if(cart != null) {
			return new ShoppingCart(cart);
		}
		return null;
	}
	
	public long getId() {
		return id;
	}

	public boolean addItem(ShoppingCartItem item) {
		item = ShoppingCartItem.copy(item);
		checkItem(item);
		
		boolean added = false;
		if(hasItem(item)) {
			getItem(item).increaseQuantity(item.getQuantity());
			added = true;
		} else {
			added = items.add(item);
		}
		
		if(added) {
			setLastUpdatedDate();
		}
		return added;
	}
	
	public boolean removeItem(ShoppingCartItem item) {
		item = ShoppingCartItem.copy(item);
		checkItem(item);
		
		if(items.remove(item)) {
			setLastUpdatedDate();
			return true;
		}
		return false;
	}
	
	public boolean hasItem(ShoppingCartItem item) {
		item = ShoppingCartItem.copy(item);
		checkItem(item);
		return items.contains(item);
	}
	
	public void removeAllItems() {
		items = new ArrayList<ShoppingCartItem>();
		setLastUpdatedDate();
	}
	
	public List<ShoppingCartItem> getItems() {
		return ShoppingCartItem.copyAll(items);
	}
	
	public void setItems(List<ShoppingCartItem> items) {
		items = ShoppingCartItem.copyAll(items);
		checkItems(items);
		this.items = items;
		setLastUpdatedDate();
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
	
	public Date getLastUpdatedDate() {
		return Dates.copy(lastUpdatedDate);
	}
	
	private void setLastUpdatedDate() {
		lastUpdatedDate = Dates.now();
	}
	
	private ShoppingCartItem getItem(ShoppingCartItem existingItem) {
		for(ShoppingCartItem item : items) {
			if(item.equals(existingItem)) {
				return item;
			}
		}
		return null;
	}
	
	private void checkItem(ShoppingCartItem item) {
		checkNotNull(item, "item cannot be null");
	}
	
	private void checkItems(List<ShoppingCartItem> items) {
		checkNotNull(items, "items cannot be null");
		checkArgument(!items.contains(null), "items cannot contain nulls");
	}
}
