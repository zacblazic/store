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

package za.co.invoketech.store.domain.model.wishlist;

import static com.google.common.base.Preconditions.*;

import static za.co.invoketech.store.application.util.DefensiveDate.copyDate;

import java.io.Serializable;
import java.util.Calendar;
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

import za.co.invoketech.store.domain.model.product.Product;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "WISH_LIST_ITEM")
public class WishListItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "WISH_LIST_ITEM_ID")
	private long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ADDED_DATE", nullable = false)
	private Date addedDate;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public WishListItem() {}
	
	public WishListItem(Product product) {
		checkProduct(product);
		this.product = product;
		this.addedDate = Calendar.getInstance().getTime();
	}
	
	public WishListItem(WishListItem item) {
		checkWishListItem(item);
		this.id = item.id;
		this.product = item.product;
		this.addedDate = copyDate(item.addedDate);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getAddedDate() {
		return copyDate(addedDate);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		checkProduct(product);
		this.product = product;
	}
	
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof WishListItem)) {
			return false;
		}
		
		WishListItem other = (WishListItem)object;
		
		if(!this.product.equals(other.product)) {
			return false;
		}
		
		return true;
	}
	
	private void checkWishListItem(WishListItem item) {
		checkNotNull(item, "item cannot be null");
	}
	
	private void checkProduct(Product product) {
		checkNotNull(product, "product cannot be null");
		checkArgument(product.getId() != 0, "product has not been persisted");
	}
}
