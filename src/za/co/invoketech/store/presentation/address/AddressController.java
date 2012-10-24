package za.co.invoketech.store.presentation.address;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.modelmapper.ModelMapper;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.CustomerNotFoundException;
import za.co.invoketech.store.application.exception.CustomerNotLinkedException;
import za.co.invoketech.store.application.exception.MaximumAddressesReachedException;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.service.customer.CustomerService;

import com.google.inject.Inject;

@RequestScoped
@ManagedBean
public class AddressController {
		
	@Inject private ModelMapper mapper;
	@Inject private CustomerService customerService;
	
	@ManagedProperty(value = "#{addressBean}")
	private AddressBean addressBean;

	public AddressController() {
		Goose.guicify(this);
	}
	
	public AddressBean getAddressBean() {
		return addressBean;
	}

	public void setAddressBean(AddressBean addressBean) {
		this.addressBean = addressBean;
	}
	
	public void add() {
		Subject currentUser = SecurityUtils.getSubject();
		String email = (String)currentUser.getPrincipal();
		long customerId = 0;
		
		try {
			customerId = customerService.findCustomerIdByEmail(email);
		} catch (AccountNotFoundException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Could not add address",  "Account was not found");  
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (CustomerNotLinkedException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Could not add address",  "No customer is linked to this account");  
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
		Address address = mapper.map(addressBean, Address.class);
		
		try {
			customerService.addAddress(customerId, address);
		} catch (CustomerNotFoundException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Could not add address",  "Customer not found");  
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (MaximumAddressesReachedException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Could not add address",  "Maximum number of accounts reached");  
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
}
