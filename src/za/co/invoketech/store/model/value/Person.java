package za.co.invoketech.store.model.value;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Person {

	@Column(name = "TITLE", nullable = false)
	private String title;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	
	@Column(name = "PHONE_NUMBER", nullable = false)
	private String phoneNumber;
	
	public Person() {}
	
	public Person(String title, String firstName, String lastName, String phoneNumber) {
		checkTitle(title);
		checkFirstName(firstName);
		checkLastName(lastName);
		checkPhoneNumber(phoneNumber);
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	private Person(Person person) {
		title = person.title;
		firstName = person.firstName;
		lastName = person.lastName;
		phoneNumber = person.phoneNumber;
	}
	
	/**
	 * Defensively copies a Person.
	 */
	public static Person copy(Person person) {
		if(person != null) {
			return new Person(person);
		} else {
			return null;
		}
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		checkTitle(title);
		this.title = title;
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

	private void checkTitle(String title) {
		checkNotNull(title, "title cannot be null");
		checkArgument(!title.isEmpty(), "title cannot be empty");
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
}
