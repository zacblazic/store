package za.co.invoketech.store.model.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACCOUNT_ID")
	private long id;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
   
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCOUNT_ID")
	private List<Preference> preferenceList;
	
	@Column(name = "DELETED")
	private boolean deleted;
	
	public static Account getInstance(String username, String password) {
		Account account = new Account();
		account.username = username;
		account.password = password;
		account.preferenceList = new ArrayList<Preference>();
		
		return account;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addPreference(Preference preference) {
		preferenceList.add(preference);
	}
	
	public void removePreference(Preference preference) {
		preferenceList.remove(preference);
	}

	public List<Preference> getPreferenceList() {
		return preferenceList;
	}
	
	// TODO: Should we allow setPreferenceList()?

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}	
}
