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

package za.co.invoketech.store.model.entity.wishlist;

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

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "WISH_LIST")
public class WishList implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WISH_LIST_ID")
	private long id;
	
	@Column(name = "LABEL")
	private String label;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "WISH_LIST_ID", nullable = false)
	private List<WishListItem> itemList;

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
		this.label = label;
	}

	public Date getCreationDate() {
		return new Date(creationDate.getTime());
	}
	
	public void addItem(WishListItem item) {
		itemList.add(item);
	}
	
	public void removeItem(WishListItem item) {
		itemList.remove(item);
	}
	
	public void removeAllItems() {
		// Used instead of clear to remove unused memory
		itemList = new ArrayList<WishListItem>();
	}
	
	public List<WishListItem> getItems() {
		return itemList;
	}
	
	// TODO: Should we allow setItems()?
	
	public int getItemCount() {
		return itemList.size();
	}
}
