package za.co.invoketech.store.model.customer;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import za.co.invoketech.store.model.address.AddressBook;

@Entity
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	
//	private String title;
//	private String firstName;
//	private String lastName;
//	private String phoneNumber;
	
	@OneToOne
	private AddressBook addressBook;

}
