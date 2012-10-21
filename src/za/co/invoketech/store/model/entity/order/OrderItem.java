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

package za.co.invoketech.store.model.entity.order;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import static za.co.invoketech.store.application.util.DefensiveDate.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import za.co.invoketech.store.model.entity.product.Product;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_QUANTITY = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ORDER_ITEM_ID")
	private long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;
	
	@Column(name = "UNIT_PRICE", nullable = false)
	private BigDecimal unitPrice;
	
	@Column(name = "QUANTITY", nullable = false)
	private int quantity;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DISPATCHED_DATE")
	private Date dispatchedDate;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public OrderItem() {}
	
	public OrderItem(Product product, BigDecimal unitPrice) {
		this(product, unitPrice, DEFAULT_QUANTITY);
	}
	
	public OrderItem(Product product, BigDecimal unitPrice, int quantity) {
		checkProduct(product);
		checkUnitPrice(unitPrice);
		checkQuantity(quantity);
		this.product = product;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	
	public OrderItem(OrderItem item) {
		checkOrderItem(item);
		this.id = item.id;
		this.product = item.product;
		this.unitPrice = item.unitPrice;
		this.quantity = item.quantity;
		this.dispatchedDate = copyDate(item.dispatchedDate);
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
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		checkUnitPrice(unitPrice);
		this.unitPrice = unitPrice;
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
	
	public Date getDispatchedDate() {
		return new Date(dispatchedDate.getTime());
	}

	public void setDispatchedDate(Date dispatchedDate) {
		checkDispatchedDate(dispatchedDate);
		this.dispatchedDate = new Date(dispatchedDate.getTime());
	}

	@Override
	public boolean equals(Object object) {
		if(!(object instanceof OrderItem)) {
			return false;
		}
		
		OrderItem other = (OrderItem)object;
		
		if(!this.product.equals(other.product)) {
			return false;
		}
		
		return true;
	}
	
	private void checkOrderItem(OrderItem item) {
		checkNotNull(item, "item cannot be null");
	}
	
	private void checkProduct(Product product) {
		checkNotNull(product, "product cannot be null");
		checkArgument(product.getId() != 0, "product has not been persisted");
	}
	
	private void checkUnitPrice(BigDecimal unitPrice) {
		checkNotNull(unitPrice, "unitPrice cannot be null");
		checkArgument(unitPrice.compareTo(BigDecimal.ZERO) > 0, "unitPrice cannot be <= 0");
	}
	
	private void checkQuantity(int quantity) {
		checkArgument(quantity > 0, "quantity cannot be < 1");
	}
	
	private void checkDispatchedDate(Date dispatchedDate) {
		checkNotNull(dispatchedDate, "dispatchedDate cannot be null");
	}
}
