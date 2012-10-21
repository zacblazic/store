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

import static com.google.common.base.Preconditions.*;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "SHOPPING_CART_ITEM_ID")
	private long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;
	
	@Column(name = "QUANTITY", nullable = false)
	private int quantity;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public ShoppingCartItem() {}
	
	public ShoppingCartItem(Product product) {
		this(product, DEFAULT_QUANTITY);
	}
	
	public ShoppingCartItem(Product product, int quantity) {
		checkProduct(product);
		checkQuantity(quantity);
		this.product = product;
		this.quantity = quantity;
	}
	
	public ShoppingCartItem(ShoppingCartItem item) {
		this.id = item.id;
		this.product = item.product;
		this.quantity = item.quantity;
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
		checkProduct(product);
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		checkQuantity(quantity);
		this.quantity = quantity;
	}
	
	public void increaseQuantity(int amount) {
		int newQuantity = quantity + amount;
		checkQuantity(newQuantity);
		quantity = newQuantity;
	}
	
	public void decreaseQuantity(int amount) {
		int newQuantity = quantity - amount;
		checkQuantity(newQuantity);
		quantity = newQuantity;
	}
	
	public void resetQuantity() {
		quantity = 1;
	}
	
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof ShoppingCartItem)) {
			return false;
		}
		
		ShoppingCartItem other = (ShoppingCartItem)object;
		
		if(!this.product.equals(other.product)) {
			return false;
		}
		
		return true;
	}
	
	private void checkProduct(Product product) {
		checkNotNull(product, "product cannot be null");
		checkArgument(product.getId() != 0, "product has not been persisted");
	}
	
	private void checkQuantity(int quantity) {
		checkArgument(quantity > 0, "quantity cannot be < 1");
	}
}
