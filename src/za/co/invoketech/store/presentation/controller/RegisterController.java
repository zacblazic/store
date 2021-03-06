package za.co.invoketech.store.presentation.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.application.exception.AccountExistsException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.application.util.Faces;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.shared.Person;
import za.co.invoketech.store.presentation.model.AccountBean;
import za.co.invoketech.store.presentation.model.AddressBean;
import za.co.invoketech.store.presentation.model.PersonBean;
import za.co.invoketech.store.service.account.RoleService;
import za.co.invoketech.store.service.customer.CustomerService;

import com.google.inject.Inject;

@RequestScoped
@ManagedBean
public class RegisterController {

	@Inject CustomerService customerService;
	@Inject RoleService roleService;
	
	@ManagedProperty(value="#{personBean}")
	private PersonBean personBean;
	
	@ManagedProperty(value="#{addressBean}")
	private AddressBean addressBean;
	
	@ManagedProperty(value="#{accountBean}")
	private AccountBean accountBean;
	
	public RegisterController() {
		Goose.guicify(this);
	}
	
	public PersonBean getPersonBean() {
		return personBean;
	}

	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}

	public AddressBean getAddressBean() {
		return addressBean;
	}

	public void setAddressBean(AddressBean addressBean) {
		this.addressBean = addressBean;
	}

	public AccountBean getAccountBean() {
		return accountBean;
	}

	public void setAccountBean(AccountBean accountBean) {
		this.accountBean = accountBean;
	}

	public String register() {	
		addressBean.setLabel("Default");
		addressBean.setFirstName(personBean.getFirstName());
		addressBean.setLastName(personBean.getLastName());
		addressBean.setPhoneNumber(personBean.getPhoneNumber());
		
		Person person = personBean.toPerson();
		Address address = addressBean.toAddress();
		Account account = accountBean.toAccount();

		try {
			customerService.createCustomer(person, address, account);
			Faces.showInfoMessage("Registration successful!", "");
			
		} catch (RoleNotFoundException e) {
			System.out.println(e);
			Faces.showErrorMessage("Woah I think something just broke!", "");
		} catch (AccountExistsException e) {
			System.out.println(e);
			Faces.showErrorMessage("Oops, that email address has already been registered.", "");
		}
		
		return "";
	}	
}
