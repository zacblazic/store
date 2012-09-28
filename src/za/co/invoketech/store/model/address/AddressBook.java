package za.co.invoketech.store.model.address;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS_BOOK")
public class AddressBook implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESS_BOOK_ID")
	private long addressBookId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address primaryAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addressList;
	
	public Address getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(Address primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
	
	public List<Address> getAddressList() {
		return addressList;
	}
	
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
}
