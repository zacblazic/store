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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import static za.co.invoketech.store.application.util.DefensiveDate.copyDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "WISH_LIST")
public class WishList implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "WISH_LIST_ID")
	private long id;
	
	@Column(name = "LABEL", nullable = false)
	private String label;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATE_DATE", nullable = false)
	private Date lastUpdatedDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "WISH_LIST_ID", nullable = false)
	private List<WishListItem> items;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public WishList() {}
	
	public WishList(String label) {
		this(label, new ArrayList<WishListItem>());
	}
	
	public WishList(String label, List<WishListItem> items) {
		checkLabel(label);
		checkItems(items);
		
		Date currentDate = Calendar.getInstance().getTime();
		
		this.label = label;
		this.createdDate = currentDate;
		this.lastUpdatedDate = currentDate;
		this.items = copyItems(items);
	}
	
	public WishList(WishList wishList) {
		checkWishList(wishList);
		this.id = wishList.id;
		this.label = wishList.label;
		this.createdDate = copyDate(wishList.createdDate);
		this.lastUpdatedDate = copyDate(wishList.lastUpdatedDate);
		this.items = copyItems(items);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		checkLabel(label);
		this.label = label;
		setLastUpdatedDate();
	}

	public Date getCreatedDate() {
		return copyDate(createdDate);
	}
	
	public Date getLastUpdatedDate() {
		return copyDate(lastUpdatedDate);
	}
	
	public void addItem(WishListItem item) {
		checkItem(item);
		items.add(item);
		setLastUpdatedDate();
	}
	
	public void removeItem(WishListItem item) {
		checkItem(item);
		items.remove(item);
		setLastUpdatedDate();
	}
	
	public boolean hasItem(WishListItem item) {
		checkItem(item);
		return items.contains(item);
	}
	
	public void removeAllItems() {
		items = new ArrayList<WishListItem>();
		setLastUpdatedDate();
	}
	
	public List<WishListItem> getItems() {
		return copyItems(items);
	}
	
	public void setItems(List<WishListItem> items) {
		checkItems(items);
		this.items = copyItems(items);
		setLastUpdatedDate();
	}
	
	public int getItemCount() {
		return items.size();
	}
	
	private void setLastUpdatedDate() {
		lastUpdatedDate = Calendar.getInstance().getTime();
	}
	
	private List<WishListItem> copyItems(List<WishListItem> items) {
		List<WishListItem> copiedItems = new ArrayList<WishListItem>();
		
		for(WishListItem item : items) {
			copiedItems.add(new WishListItem(item));
		}
		
		return copiedItems;
	}
	
	private void checkWishList(WishList wishList) {
		checkNotNull(wishList, "wishList cannot be null");
	}
	
	private void checkLabel(String label) {
		checkNotNull(label, "label cannot be null");
		checkArgument(!label.isEmpty(), "label cannot be empty");
	}
	
	private void checkItem(WishListItem item) {
		checkNotNull(item, "item cannot be null");
	}
	
	private void checkItems(List<WishListItem> items) {
		checkNotNull(items, "items cannot be null");
		checkArgument(!items.contains(null), "items cannot contain nulls");
	}
}
