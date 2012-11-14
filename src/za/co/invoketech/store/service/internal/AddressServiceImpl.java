package za.co.invoketech.store.service.internal;

import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.order.DeliveryAddress;
import za.co.invoketech.store.domain.shared.InternalAddress;
import za.co.invoketech.store.service.address.AddressService;

public class AddressServiceImpl implements AddressService {

	@Override
	public DeliveryAddress createDeliveryAddress(Address address) {
		InternalAddress internalAddress = new InternalAddress.Builder()
			.firstName(address.getFirstName())
			.lastName(address.getLastName())
			.phoneNumber(address.getPhoneNumber())
			.line1(address.getLine1())
			.line2(address.getLine2())
			.city(address.getCity())
			.postalCode(address.getPostalCode())
			.country(address.getCountry())
			.addressType(address.getAddressType())
			.build();
		
		return new DeliveryAddress(internalAddress);
	}
}
