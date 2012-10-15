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

package za.co.invoketech.store.model.entity.customer;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import za.co.invoketech.store.model.entity.account.Account;
import za.co.invoketech.store.model.entity.shoppingcart.ShoppingCart;
import za.co.invoketech.store.model.entity.wishlist.WishList;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	private long id;
	
	@Column(name = "TITLE", nullable = false)
	private String title;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	
	@Column(name = "PHONE_NUMBER", nullable = false)
	private String phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PRIMARY_ADDRESS_ID")
	private CustomerAddress primaryAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")
	private List<CustomerAddress> addresses;
	
	@OneToOne
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;
	
	@OneToOne
	@JoinColumn(name = "SHOPPING_CART_ID")
	private ShoppingCart shoppingCart;
	
	@OneToMany
	@JoinColumn(name = "CUSTOMER_ID")
	private List<WishList> wishLists;
	
	@Column(name = "DELETED")
	private boolean deleted;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		checkNotNull(title);
		checkArgument(!title.isEmpty(), "title cannot be empty");
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		checkNotNull(firstName);
		checkArgument(!firstName.isEmpty(), "firstName cannot be empty");
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		checkNotNull(lastName);
		checkArgument(!lastName.isEmpty(), "lastName cannot be empty");
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		checkNotNull(phoneNumber);
		checkArgument(!phoneNumber.isEmpty(), "phoneNumber cannot be empty");
		this.phoneNumber = phoneNumber;
	}
	
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<WishList> getWishLists() {
		return wishLists;
	}

	public void setWishLists(List<WishList> wishLists) {
		this.wishLists = wishLists;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
