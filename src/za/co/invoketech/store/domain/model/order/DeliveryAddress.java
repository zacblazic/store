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

package za.co.invoketech.store.domain.model.order;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import za.co.invoketech.store.domain.shared.InternalAddress;
import za.co.invoketech.store.domain.shared.AddressType;

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
	private InternalAddress internalAddress;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public DeliveryAddress() {}
	
	public DeliveryAddress(InternalAddress internalAddress) {
		checkInternalAddress(internalAddress);
		this.internalAddress = InternalAddress.copy(internalAddress);
	}
	
	private DeliveryAddress(DeliveryAddress deliveryAddress) {
		id = deliveryAddress.id;
		internalAddress = InternalAddress.copy(deliveryAddress.internalAddress);
	}
	
	public static DeliveryAddress copy(DeliveryAddress deliveryAddress) {
		if(deliveryAddress != null) {
			return new DeliveryAddress(deliveryAddress);
		}
		return null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return internalAddress.getFirstName();
	}

	public void setFirstName(String firstName) {
		internalAddress.setFirstName(firstName);
	}

	public String getLastName() {
		return internalAddress.getLastName();
	}

	public void setLastName(String lastName) {
		internalAddress.setLastName(lastName);
	}

	public String getPhoneNumber() {
		return internalAddress.getPhoneNumber();
	}

	public void setPhoneNumber(String phoneNumber) {
		internalAddress.setPhoneNumber(phoneNumber);
	}

	public String getLine1() {
		return internalAddress.getLine1();
	}

	public void setLine1(String line1) {
		internalAddress.setLine1(line1);
	}

	public String getLine2() {
		return internalAddress.getLine2();
	}

	public void setLine2(String line2) {
		internalAddress.setLine2(line2);
	}

	public String getCity() {
		return internalAddress.getCity();
	}

	public void setCity(String city) {
		internalAddress.setCity(city);
	}

	public String getPostalCode() {
		return internalAddress.getPostalCode();
	}

	public void setPostalCode(String postalCode) {
		internalAddress.setPostalCode(postalCode);
	}

	public String getCountry() {
		return internalAddress.getCountry();
	}

	public void setCountry(String country) {
		internalAddress.setCountry(country);
	}

	public AddressType getAddressType() {
		return internalAddress.getAddressType();
	}

	public void setAddressType(AddressType addressType) {
		internalAddress.setAddressType(addressType);
	}

	private void checkInternalAddress(InternalAddress internalAddress) {
		checkNotNull(internalAddress, "internalAddress cannot be null");
	}
}
