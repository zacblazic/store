package za.co.invoketech.store.presentation.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.presentation.model.AccountBean;
import za.co.invoketech.store.presentation.model.AddressBean;
import za.co.invoketech.store.presentation.model.PersonBean;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.customer.CustomerService;

import com.google.inject.Inject;

@RequestScoped
@ManagedBean
public class RegisterController {

	@Inject AccountService accountService;
	@Inject CustomerService customerService;
	
	@ManagedProperty(value="#{personBean}")
	private PersonBean person;
	
	@ManagedProperty(value="#{addressBean}")
	private AddressBean address;
	
	@ManagedProperty(value="#{accountBean}")
	private AccountBean account;
	
	public RegisterController() {
		Goose.guicify(this);
	}
	
	public PersonBean getPerson() {
		return person;
	}

	public void setPerson(PersonBean person) {
		this.person = person;
	}

	public AddressBean getAddress() {
		return address;
	}

	public void setAddress(AddressBean address) {
		this.address = address;
	}

	public AccountBean getAccount() {
		return account;
	}

	public void setAccount(AccountBean account) {
		this.account = account;
	}

	public String register() {
		return "";
	}	
}
