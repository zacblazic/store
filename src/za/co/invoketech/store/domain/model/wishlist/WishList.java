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
@Table(name = "WISH_LIST")
public class WishList implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "WISH_LIST_ID")
	private long id;
	
	@Column(name = "LABEL", nullable = false)
	private String label;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "WISH_LIST_ID")
	private List<WishListItem> items;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATE_DATE", nullable = false)
	private Date lastUpdatedDate;
	
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
		this.label = label;
		this.createdDate = Dates.now();
		this.lastUpdatedDate = Dates.now();
		this.items = new ArrayList<>(items);
	}
	
	private WishList(WishList list) {
		this.id = list.id;
		this.label = list.label;
		this.createdDate = Dates.copy(list.createdDate);
		this.lastUpdatedDate = Dates.copy(list.lastUpdatedDate);
		this.items = new ArrayList<>(list.items);
	}
	
	public static WishList copy(WishList list) {
		if(list != null) {
			return new WishList(list);
		}
		return null;
	}
	
	public static List<WishList> copyAll(List<WishList> lists) {
		List<WishList> copiedLists = new ArrayList<>();
		for(WishList list : lists) {
			copiedLists.add(copy(list));
		}
		return copiedLists;
	}

	public long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		checkLabel(label);
		this.label = label;
		setLastUpdatedDate();
	}
	
	public boolean addItem(WishListItem item) {
		checkItem(item);
		if(items.add(item)) {
			setLastUpdatedDate();
			return true;
		}
		return false;
	}
	
	public boolean removeItem(WishListItem item) {
		checkItem(item);
		if(items.remove(item)) {
			setLastUpdatedDate();
			return true;
		}
		return false;
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
		return new ArrayList<>(items);
	}
	
	public void setItems(List<WishListItem> items) {
		items = new ArrayList<>(items);
		checkItems(items);
		this.items = items;
		setLastUpdatedDate();
	}
	
	public int getItemCount() {
		return items.size();
	}
	
	public Date getCreatedDate() {
		return Dates.copy(createdDate);
	}
	
	public Date getLastUpdatedDate() {
		return Dates.copy(lastUpdatedDate);
	}
	
	private void setLastUpdatedDate() {
		lastUpdatedDate = Dates.now();
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
