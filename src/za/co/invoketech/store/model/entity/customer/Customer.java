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
import javax.persistence.Embedded;
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
import za.co.invoketech.store.model.value.Person;

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
	
	@Embedded
	private Person person;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRIMARY_ADDRESS_ID")
	private CustomerAddress primaryAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")
	private List<CustomerAddress> addresses;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID", nullable = false)
	private Account account;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SHOPPING_CART_ID", nullable = false) 
	private ShoppingCart shoppingCart;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")
	private List<WishList> wishLists;
	
	@OneToMany(mappedBy = "customer")
	@JoinColumn(name = "CUSTOMER_ID")
	private List<Order> orders;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public Customer() {}
	
	public Customer(Person person, Account account) {
		checkPerson(person);
		checkAccount(account);
		this.person = Person.copy(person);
		this.account = account;
		shoppingCart = createShoppingCart();
		wishLists = createWishLists();
		orders = createOrders();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return person.getTitle();
	}

	public void setTitle(String title) {
		person.setTitle(title);
	}

	public String getFirstName() {
		return person.getFirstName();
	}

	public void setFirstName(String firstName) {
		person.setFirstName(firstName);
	}

	public String getLastName() {
		return person.getLastName();
	}

	public void setLastName(String lastName) {
		person.setLastName(lastName);
	}

	public String getPhoneNumber() {
		return person.getPhoneNumber();
	}

	public void setPhoneNumber(String phoneNumber) {
		person.setPhoneNumber(phoneNumber);
	}

	public CustomerAddress getPrimaryAddress() {
		return CustomerAddress.copy(primaryAddress);
	}

	public void setPrimaryAddress(CustomerAddress primaryAddress) {
		checkPrimaryAddress(primaryAddress);
		this.primaryAddress = CustomerAddress.copy(primaryAddress);
	}

	public List<CustomerAddress> getAddresses() {
		return CustomerAddress.copyAll(addresses);
	}

	public void setAddresses(List<CustomerAddress> addresses) {
		checkAddresses(addresses);
		this.addresses = CustomerAddress.copyAll(addresses);
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
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		checkOrders(orders);
		this.orders = orders;
	}
	
	private ArrayList<Order> createOrders() {
		return new ArrayList<Order>();
	}

	private ArrayList<WishList> createWishLists() {
		return new ArrayList<WishList>();
	}

	private ShoppingCart createShoppingCart() {
		return new ShoppingCart(new ArrayList<ShoppingCartItem>());
	}
	
	private List<WishList> copyWishLists(List<WishList> wishLists) {
		List<WishList> copiedWishLists = createWishLists();
		
		for(WishList wishList : wishLists) {
			copiedWishLists.add(new WishList(wishList));
		}
		
		return copiedWishLists;
	}
	
	private void checkPerson(Person person) {
		checkNotNull(person, "person cannot be null");
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
	
	private void checkOrders(List<Order> orders) {
		checkNotNull(orders, "orders cannot be null");
		checkArgument(!orders.contains(null), "orders cannot contain nulls");
	}
}
