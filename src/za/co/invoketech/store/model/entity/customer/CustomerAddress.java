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

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import za.co.invoketech.store.model.value.Address;
import za.co.invoketech.store.model.value.AddressType;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "CUSTOMER_ADDRESS")
public class CustomerAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "LABEL", nullable = false)
	private String label;
	
	@Embedded
	private Address address;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public CustomerAddress() {}
	
	public CustomerAddress(String label, Address address) {
		checkLabel(label);
		checkAddress(address);
		this.label = label;
		this.address = Address.copy(address);
	}
	
	private CustomerAddress(CustomerAddress address) {
		id = address.id;
		label = address.label;
		this.address = Address.copy(address.address);
	}
	
	public static CustomerAddress copy(CustomerAddress address) {
		if(address != null) {
			return new CustomerAddress(address);
		}
		return null;
	}
	
	public static List<CustomerAddress> copyAll(List<CustomerAddress> addresses) {
		List<CustomerAddress> copiedAddresses = new ArrayList<>();
		for(CustomerAddress address : addresses) {
			copiedAddresses.add(copy(address));
		}
		return copiedAddresses;
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
	}
	
	public String getFirstName() {
		return address.getFirstName();
	}

	public void setFirstName(String firstName) {
		address.setFirstName(firstName);
	}

	public String getLastName() {
		return address.getLastName();
	}

	public void setLastName(String lastName) {
		address.setLastName(lastName);
	}

	public String getPhoneNumber() {
		return address.getPhoneNumber();
	}

	public void setPhoneNumber(String phoneNumber) {
		address.setPhoneNumber(phoneNumber);
	}

	public String getLine1() {
		return address.getLine1();
	}

	public void setLine1(String line1) {
		address.setLine1(line1);
	}

	public String getLine2() {
		return address.getLine2();
	}

	public void setLine2(String line2) {
		address.setLine2(line2);
	}

	public String getCity() {
		return address.getCity();
	}

	public void setCity(String city) {
		address.setCity(city);
	}

	public String getPostalCode() {
		return address.getPostalCode();
	}

	public void setPostalCode(String postalCode) {
		address.setPostalCode(postalCode);
	}

	public String getCountry() {
		return address.getCountry();
	}

	public void setCountry(String country) {
		address.setCountry(country);
	}

	public AddressType getAddressType() {
		return address.getAddressType();
	}

	public void setAddressType(AddressType addressType) {
		address.setAddressType(addressType);
	}

	private void checkLabel(String label) {
		checkNotNull(label, "label cannot be null");
		checkArgument(!label.isEmpty(), "label cannot be empty");
	}
	
	private void checkAddress(Address address) {
		checkNotNull(address, "address cannot be null");
	}
}
