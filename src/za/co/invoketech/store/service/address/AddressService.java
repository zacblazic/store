package za.co.invoketech.store.service.address;

import java.util.List;

import za.co.invoketech.store.model.address.Address;


public interface AddressService {

	public void addAddress();
	public void removeAddress();
	public void updateAddress();
	public List<Address> getAddressList();
	public Address getPrimaryAddress();
	public void setPrimaryAddress();
}
