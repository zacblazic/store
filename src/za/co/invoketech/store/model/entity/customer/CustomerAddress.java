package za.co.invoketech.store.model.entity.customer;

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

import static com.google.common.base.Preconditions.*;

/**
 * Entity implementation class for Entity: CustomerAddress
 *
 */
@Entity
@Table(name = "CUSTOMER_ADDRESS")
public class CustomerAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "LABEL", nullable = false)
	private String label;
	
	@Embedded
	private Address address;
	
	public CustomerAddress() {
		
	}
	
	public CustomerAddress(CustomerAddress customerAddress) {
		this.id = customerAddress.id;
		this.label = customerAddress.label;
		this.address = new Address(customerAddress.address);
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
		checkNotNull(label);
		checkArgument(!label.isEmpty(), "label cannot be empty");
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
}
