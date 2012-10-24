package za.co.invoketech.store.presentation.address;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.service.customer.CustomerService;

import com.google.inject.Inject;

@RequestScoped
@ManagedBean
public class AddressController {
		
	@Inject
	private CustomerService customerService;
	
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

	}
}
