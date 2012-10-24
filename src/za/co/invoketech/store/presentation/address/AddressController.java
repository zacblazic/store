package za.co.invoketech.store.presentation.address;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.CustomerNotFoundException;
import za.co.invoketech.store.application.exception.CustomerNotLinkedException;
import za.co.invoketech.store.application.exception.MaximumAddressesReachedException;
import za.co.invoketech.store.application.util.Faces;
import za.co.invoketech.store.service.customer.CustomerService;

import com.google.inject.Inject;

@RequestScoped
@ManagedBean
public class AddressController {
		
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
			customerService.addAddress(customerId, addressBean.toAddress());
		} catch (AccountNotFoundException e) {
			Faces.showErrorMessage("Could not add address",  "Account was not found");  
		} catch (CustomerNotLinkedException e) {
			Faces.showErrorMessage("Could not add address",  "No customer is linked to this account");  
		} catch (CustomerNotFoundException e) {
			Faces.showErrorMessage("Could not add address", "Customer was not found");
		} catch (MaximumAddressesReachedException e) {
			Faces.showErrorMessage("Could not add address",  "Maximum number of addresses reached");
		}
	}
}
