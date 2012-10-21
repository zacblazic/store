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
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import za.co.invoketech.store.model.entity.account.Account;
import za.co.invoketech.store.model.entity.order.Order;
import za.co.invoketech.store.model.entity.shoppingcart.ShoppingCart;
import za.co.invoketech.store.model.entity.shoppingcart.ShoppingCartItem;
import za.co.invoketech.store.model.entity.wishlist.WishList;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRIMARY_ADDRESS_ID", nullable = false)
	private CustomerAddress primaryAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private List<CustomerAddress> addresses;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID", nullable = false)
	private Account account;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SHOPPING_CART_ID", nullable = false) 
	private ShoppingCart shoppingCart;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private List<WishList> wishLists;
	
	@OneToMany(mappedBy = "customer")
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private List<Order> orders;
	
	public class Builder {
		
		private String title;
		private String firstName;
		private String lastName;
		private String phoneNumber;
		
		private CustomerAddress primaryAddress;
		private List<CustomerAddress> addresses;
		private Account account;
		
		public Builder(String title, String firstName, String lastName) {
			this.title = title;
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public Builder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		public Builder primaryAddress(CustomerAddress primaryAddress) {
			this.primaryAddress = primaryAddress;
			return this;
		}
		
		public Builder addresses(List<CustomerAddress> addresses) {
			this.addresses = addresses;
			return this;
		}
		
		public Builder account(Account account) {
			this.account = account;
			return this;
		}
		
		public Customer build() {
			return new Customer(this);
		}
	}
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public Customer() {}
	
	private Customer(Builder builder) {
		checkTitle(builder.title);
		checkFirstName(builder.firstName);
		checkLastName(builder.lastName);
		checkPhoneNumber(builder.phoneNumber);
		checkPrimaryAddress(builder.primaryAddress);
		checkAddresses(builder.addresses);
		checkAccount(builder.account);
		this.title = builder.title;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.phoneNumber = builder.phoneNumber;
		this.primaryAddress = new CustomerAddress(builder.primaryAddress);
		this.addresses = copyAddresses(builder.addresses);
		this.account = new Account(builder.account);
		this.shoppingCart = createEmptyShoppingCart();
		this.wishLists = new ArrayList<WishList>();
		this.orders = new ArrayList<Order>();
	}
	
	public Customer(Customer customer) {
		checkCustomer(customer);
		this.id = customer.id;
		this.firstName = customer.firstName;
		this.lastName = customer.lastName;
		this.phoneNumber = customer.phoneNumber;
		this.primaryAddress = new CustomerAddress(customer.primaryAddress);
		this.addresses = copyAddresses(customer.addresses);
		this.account = new Account(customer.account);
		this.shoppingCart = new ShoppingCart(customer.shoppingCart);
		this.wishLists = copyWishLists(customer.wishLists);
		this.orders = copyOrders(customer.orders);
	}

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
		checkTitle(title);
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		checkFirstName(firstName);
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		checkLastName(lastName);
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		checkPhoneNumber(phoneNumber);
		this.phoneNumber = phoneNumber;
	}
	
	public CustomerAddress getPrimaryAddress() {
		return new CustomerAddress(primaryAddress);
	}

	public void setPrimaryAddress(CustomerAddress primaryAddress) {
		checkPrimaryAddress(primaryAddress);
		this.primaryAddress = new CustomerAddress(primaryAddress);
	}

	public List<CustomerAddress> getAddresses() {
		return copyAddresses(addresses);
	}

	public void setAddresses(List<CustomerAddress> addresses) {
		checkAddresses(addresses);
		this.addresses = copyAddresses(addresses);
	}

	public ShoppingCart getShoppingCart() {
		return new ShoppingCart(shoppingCart);
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		checkShoppingCart(shoppingCart);
		this.shoppingCart = new ShoppingCart(shoppingCart);
	}

	public List<WishList> getWishLists() {
		return copyWishLists(wishLists);
	}

	public void setWishLists(List<WishList> wishLists) {
		checkWishLists(wishLists);
		this.wishLists = copyWishLists(wishLists);
	}
	
	public List<Order> getOrders() {
		return copyOrders(orders);
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = copyOrders(orders);
	}
	
	private ShoppingCart createEmptyShoppingCart() {
		return new ShoppingCart(new ArrayList<ShoppingCartItem>());
	}
	
	private List<CustomerAddress> copyAddresses(List<CustomerAddress> addresses) {
		List<CustomerAddress> copiedAddresses = new ArrayList<CustomerAddress>();
		
		for(CustomerAddress address : addresses) {
			copiedAddresses.add(new CustomerAddress(address));
		}
		
		return copiedAddresses;
	}
	
	private List<WishList> copyWishLists(List<WishList> wishLists) {
		List<WishList> copiedWishLists = new ArrayList<WishList>();
		
		for(WishList wishList : wishLists) {
			copiedWishLists.add(new WishList(wishList));
		}
		
		return copiedWishLists;
	}
	
	private List<Order> copyOrders(List<Order> orders) {
		List<Order> copiedOrders = new ArrayList<Order>();
		
		for(Order order : orders) {
			copiedOrders.add(new Order(order));
		}
		
		return copiedOrders;
	}
	
	private void checkCustomer(Customer customer) {
		checkNotNull(customer, "customer cannot be null");
	}
	
	private void checkTitle(String title) {
		checkNotNull(title, "title cannot be null");
		checkArgument(!title.isEmpty(), "title cannot be empty");
	}
	
	private void checkFirstName(String firstName) {
		checkNotNull(firstName, "firstName cannot be null");
		checkArgument(!firstName.isEmpty(), "firstName cannot be empty");
	}
	
	private void checkLastName(String lastName) {
		checkNotNull(lastName, "lastName cannot be null");
		checkArgument(!lastName.isEmpty(), "lastName cannot be empty");
	}
	
	private void checkPhoneNumber(String phoneNumber) {
		checkNotNull(phoneNumber, "phoneNumber cannot be null");
		checkArgument(!phoneNumber.isEmpty(), "phoneNumber cannot be empty");
	}
	
	private void checkPrimaryAddress(CustomerAddress primaryAddress) {
		checkNotNull(primaryAddress, "primaryAddress cannot be null");
	}
	
	private void checkAddresses(List<CustomerAddress> addresses) {
		checkNotNull(addresses, "addresses cannot be null");
		checkArgument(addresses.size() != 0, "addresses cannot be empty");
		checkArgument(!addresses.contains(null), "addresses cannot contain nulls");
	}
	
	private void checkAccount(Account account) {
		checkNotNull(account, "account cannot be null");
	}
	
	private void checkShoppingCart(ShoppingCart shoppingCart) {
		checkNotNull(shoppingCart, "shoppingCart cannot be null");
	}
	
	private void checkWishLists(List<WishList> wishLists) {
		checkNotNull(wishLists, "wishLists cannot be null");
		checkArgument(!wishLists.contains(null), "wishLists cannot contain nulls");
	}
}
