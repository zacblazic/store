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

package za.co.invoketech.store.domain.shared;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Embeddable
public class InternalAddress implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "LINE_1")
	private String line1;
	
	@Column(name = "LINE_2")
	private String line2;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "POSTAL_CODE")
	private String postalCode;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ADDRESS_TYPE")
	private AddressType addressType;

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
		
		public Builder(String firstName, String lastName, String phoneNumber) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
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
		
		public InternalAddress build() {
			return new InternalAddress(this);
		}
	}
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public InternalAddress() {}
	
	private InternalAddress(Builder builder) {
		checkFirstName(builder.firstName);
		checkLastName(builder.lastName);
		checkPhoneNumber(builder.phoneNumber);
		checkLine1(builder.line1);
		checkLine2(builder.line2);
		checkCity(builder.city);
		checkPostalCode(builder.postalCode);
		checkCountry(builder.country);
		checkAddressType(builder.addressType);
		firstName = builder.firstName;
		lastName = builder.lastName;
		phoneNumber = builder.phoneNumber;
		line1 = builder.line1;
		line2 = builder.line2;
		city = builder.city;
		postalCode = builder.postalCode;
		country = builder.country;
		addressType = builder.addressType;
	}
	
	private InternalAddress(InternalAddress address) {
		firstName = address.firstName;
		lastName = address.lastName;
		phoneNumber = address.phoneNumber;
		line1 = address.line1;
		line2 = address.line2;
		city = address.city;
		postalCode = address.postalCode;
		country = address.country;
		addressType = address.addressType;
	}
	
	/**
	 * Defensively copies an Address.
	 */
	public static InternalAddress copy(InternalAddress address) {
		if(address != null) {
			return new InternalAddress(address);
		}
		return null;
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

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		checkLine1(line1);
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		checkLine2(line2);
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		checkCity(city);
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		checkPostalCode(postalCode);
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		checkCountry(country);
		this.country = country;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		checkAddressType(addressType);
		this.addressType = addressType;
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
