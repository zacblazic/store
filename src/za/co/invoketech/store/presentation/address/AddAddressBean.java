package za.co.invoketech.store.presentation.address;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class AddAddressBean {
	
	@ManagedProperty(value = "#{addressBean}")
	private AddressBean addressBean;

	public AddressBean getAddressBean() {
		return addressBean;
	}

	public void setAddressBean(AddressBean addressBean) {
		this.addressBean = addressBean;
	}
	
	public void addAddress() {
		
	}
}
