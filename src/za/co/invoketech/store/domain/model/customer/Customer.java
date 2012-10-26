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

package za.co.invoketech.store.domain.model.customer;

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

import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.cart.ShoppingCart;
import za.co.invoketech.store.domain.model.cart.ShoppingCartItem;
import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.domain.model.wishlist.WishList;
import za.co.invoketech.store.domain.shared.Gender;
import za.co.invoketech.store.domain.shared.Person;

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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")
	private List<Address> addresses;
	
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
	
	public Customer(Person person, Address primary, Account account) {
		checkPerson(person);
		checkPrimaryAddress(primary);
		checkAccount(account);
		this.person = Person.copy(person);
		this.addresses = createAddressesWithPrimary(primary);
		this.account = account;
		shoppingCart = createShoppingCart();
		wishLists = createWishLists();
		orders = createOrders();
	}

	public long getId() {
		return id;
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

	public Gender getGender() {
		return person.getGender();
	}

	public void setGender(Gender gender) {
		person.setGender(gender);
	}

	public String getPhoneNumber() {
		return person.getPhoneNumber();
	}

	public void setPhoneNumber(String phoneNumber) {
		person.setPhoneNumber(phoneNumber);
	}
	
	public Account getAccount() {
		return account;
	}
	
	public boolean addAddress(Address address) {
		address = Address.copy(address);
		checkAddress(address);
		return addresses.add(address);
	}
	
	public boolean removeAddress(Address address) {
		address = Address.copy(address);
		checkAddress(address);
		return addresses.remove(address);
	}
	
	public Address getPrimaryAddress() {
		for(Address address : addresses) {
			if(address.isPrimary()) {
				return address;
			}
		}
		return null;
	}
	
	public Address getAddressByLabel(String label) {
		for(Address address : addresses) {
			if(address.getLabel().equalsIgnoreCase(label)) {
				return address;
			}
		}
		return null;
	}
	
	public boolean hasAddressWithLabel(String label) {
		for(Address address : addresses) {
			if(address.getLabel().equalsIgnoreCase(label)) {
				return true;
			}
		}
		return false;
	}

	public int getAddressCount() {
		return addresses.size();
	}

	public List<Address> getAddresses() {
		return Address.copyAll(addresses);
	}
	
	public void setAddresses(List<Address> addresses) {
		checkAddresses(addresses);
		this.addresses = Address.copyAll(addresses);
	}
	
	private int getPrimaryAddressCount(List<Address> addresses) {
		int count = 0;
		for(Address address : addresses) {
			if(address.isPrimary()) {
				count++;
			}
		}
		return count;
	}

	public ShoppingCart getShoppingCart() {
		return ShoppingCart.copy(shoppingCart);
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		checkShoppingCart(shoppingCart);
		this.shoppingCart = ShoppingCart.copy(shoppingCart);
	}

	public List<WishList> getWishLists() {
		return WishList.copyAll(wishLists);
	}

	public void setWishLists(List<WishList> wishLists) {
		checkWishLists(wishLists);
		this.wishLists = WishList.copyAll(wishLists);
	}
	
	public List<Order> getOrders() {
		return new ArrayList<>(orders);
	}
	
	public void setOrders(List<Order> orders) {
		checkOrders(orders);
		this.orders = new ArrayList<>(orders);
	}
	
	private List<Address> createAddressesWithPrimary(Address address) {
		List<Address> addresses = new ArrayList<>();
		address.setPrimary(true);
		addresses.add(address);
		return addresses;
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
	
	private void checkPerson(Person person) {
		checkNotNull(person, "person cannot be null");
	}
	
	private void checkAddress(Address address) {
		checkNotNull(address, "address cannot be null");
	}
	
	private void checkPrimaryAddress(Address address) {
		checkNotNull(address, "address cannot be null");
		checkNotNull(address.isPrimary(), "address must be primary");
	}
	
	private void checkAddresses(List<Address> addresses) {
		checkNotNull(addresses, "addresses cannot be null");
		checkArgument(addresses.size() != 0, "addresses cannot be empty");
		checkArgument(!addresses.contains(null), "addresses cannot contain nulls");
		checkArgument(getPrimaryAddressCount(addresses) < 1, "addresses does not contain a primary address");
		checkArgument(getPrimaryAddressCount(addresses) > 1, "addresses contains too many primary addresses");
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
