package za.co.invoketech.store.model.address;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ADDRESS_TYPE")
public abstract class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESS_ID")
	private long id;
	
	@Column(name = "LABEL")
	protected String label;
	
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
	
	// TODO: Add static constructor
	
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
		this.label = label;
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
