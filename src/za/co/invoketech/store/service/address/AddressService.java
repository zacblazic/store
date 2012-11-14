package za.co.invoketech.store.service.address;

import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.order.DeliveryAddress;

public interface AddressService {

	DeliveryAddress createDeliveryAddress(Address address);
}
