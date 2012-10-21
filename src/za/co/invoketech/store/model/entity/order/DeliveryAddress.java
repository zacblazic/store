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

import java.io.Serializable;

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
@Table(name = "DELIVERY_ADDRESS")
public class DeliveryAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "DELIVERY_ADDRESS_ID")
	private long id;
	
	@Embedded
	private Address address;
	
	public static class Builder {

		private String firstName;
		private String lastName;
		private String phoneNumber;
		private String line1;
		private String line2;
		private String city;
		private String postalCode;
		private String country;
		private AddressType addressType;
		
		public Builder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public Builder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		public Builder line1(String line1) {
			this.line1 = line1;
			return this;
		}
		
		public Builder line2(String line2) {
			this.line2 = line2;
			return this;
		}
		
		public Builder city(String city) {
			this.city = city;
			return this;
		}
		
		public Builder postalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}
		
		public Builder country(String country) {
			this.country = country;
			return this;
		}
		
		public Builder addressType(AddressType addressType) {
			this.addressType = addressType;
			return this;
		}
		
		public DeliveryAddress build() {
			return new DeliveryAddress(this);
		}
	}
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public DeliveryAddress() {}
	
	private DeliveryAddress(Builder builder) {
		checkFirstName(builder.firstName);
		checkLastName(builder.lastName);
		checkPhoneNumber(builder.phoneNumber);
		checkLine1(builder.line1);
		checkLine2(builder.line2);
		checkCity(builder.city);
		checkPostalCode(builder.postalCode);
		checkCountry(builder.country);
		checkAddressType(builder.addressType);
		address = new Address();
		address.setFirstName(builder.firstName);
		address.setLastName(builder.lastName);
		address.setPhoneNumber(builder.phoneNumber);
		address.setLine1(builder.line1);
		address.setLine2(builder.line2);
		address.setCity(builder.city);
		address.setPostalCode(builder.postalCode);
		address.setCountry(builder.country);
		address.setAddressType(builder.addressType);
	}
	
	public DeliveryAddress(DeliveryAddress deliveryAddress) {
		checkDeliveryAddress(deliveryAddress);
		this.id = deliveryAddress.id;
		this.address = new Address(deliveryAddress.address);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return address.getFirstName();
	}

	public void setFirstName(String firstName) {
		checkFirstName(firstName);
		address.setFirstName(firstName);
	}

	public String getLastName() {
		return address.getLastName();
	}

	public void setLastName(String lastName) {
		checkLastName(lastName);
		address.setLastName(lastName);
	}

	public String getPhoneNumber() {
		return address.getPhoneNumber();
	}

	public void setPhoneNumber(String phoneNumber) {
		checkPhoneNumber(phoneNumber);
		address.setPhoneNumber(phoneNumber);
	}

	public String getLine1() {
		return address.getLine1();
	}

	public void setLine1(String line1) {
		checkLine1(line1);
		address.setLine1(line1);
	}

	public String getLine2() {
		return address.getLine2();
	}

	public void setLine2(String line2) {
		checkLine2(line2);
		address.setLine2(line2);
	}

	public String getCity() {
		return address.getCity();
	}

	public void setCity(String city) {
		checkCity(city);
		address.setCity(city);
	}

	public String getPostalCode() {
		return address.getPostalCode();
	}

	public void setPostalCode(String postalCode) {
		checkPostalCode(postalCode);
		address.setPostalCode(postalCode);
	}

	public String getCountry() {
		return address.getCountry();
	}

	public void setCountry(String country) {
		checkCountry(country);
		address.setCountry(country);
	}

	public AddressType getAddressType() {
		return address.getAddressType();
	}

	public void setAddressType(AddressType addressType) {
		checkAddressType(addressType);
		address.setAddressType(addressType);
	}
	
	private void checkDeliveryAddress(DeliveryAddress deliveryAddress) {
		checkNotNull(deliveryAddress, "deliveryAddress cannot be null");
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
	
	private void checkLine1(String line1) {
		checkNotNull(line1, "line1 cannot be null");
		checkArgument(!line1.isEmpty(), "line1 cannot be empty");
	}
	
	private void checkLine2(String line2) {
		checkNotNull(line2, "line2 cannot be null");
		checkArgument(!line2.isEmpty(), "line2 cannot be empty");
	}
	
	private void checkCity(String city) {
		checkNotNull(city, "city cannot be null");
		checkArgument(!city.isEmpty(), "city cannot be empty");
	}
	
	private void checkPostalCode(String postalCode) {
		checkNotNull(postalCode, "postalCode cannot be null");
		checkArgument(!postalCode.isEmpty(), "postalCode cannot be empty");
	}
	
	private void checkCountry(String country) {
		checkNotNull(country, "country cannot be null");
		checkArgument(!country.isEmpty(), "country cannot be empty");
	}
	
	private void checkAddressType(AddressType addressType) {
		checkNotNull(addressType, "addressType cannot be null");
	}
}
