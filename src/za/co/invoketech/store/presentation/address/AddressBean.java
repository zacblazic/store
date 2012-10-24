package za.co.invoketech.store.presentation.address;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.shared.AddressType;
import za.co.invoketech.store.domain.shared.InternalAddress;

@SessionScoped
@ManagedBean
public class AddressBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String label;
	private boolean primary;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String line1;
	private String line2;
	private String city;
	private String postalCode;
	private String country;
	private String addressType;
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public boolean isPrimary() {
		return primary;
	}
	
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getLine1() {
		return line1;
	}
	
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	
	public String getLine2() {
		return line2;
	}
	
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getAddressType() {
		return addressType;
	}
	
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	
	public Address toAddress() {
		InternalAddress internal = new InternalAddress.Builder()
			.firstName(getFirstName())
			.lastName(getLastName())
			.phoneNumber(getPhoneNumber())
			.line1(getLine1())
			.line2(getLine2())
			.city(getCity())
			.postalCode(getPostalCode())
			.country(getCountry())
			.addressType(AddressType.valueOf(getAddressType()))
			.build();
		
		return new Address(getLabel(), internal, isPrimary());
	}
}
