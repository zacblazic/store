package za.co.invoketech.store.model.value;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "FIRST_NAME")
	protected String firstName;
	
	@Column(name = "LAST_NAME")
	protected String lastName;
	
	@Column(name = "PHONE_NUMBER")
	protected String phoneNumber;
	
	@Column(name = "SUBURB")
	protected String suburb;
	
	@Column(name = "CITY")
	protected String city;
	
	@Column(name = "POSTAL_CODE")
	protected String postalCode;
	
	@Column(name = "COUNTRY")
	protected String country;
	
	@Column(name = "DELETED")
	protected boolean deleted;
	
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
	
	public String getSuburb() {
		return suburb;
	}
	
	public void setSuburb(String suburb) {
		this.suburb = suburb;
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
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
