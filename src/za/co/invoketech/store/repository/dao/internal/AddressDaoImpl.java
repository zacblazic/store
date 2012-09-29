package za.co.invoketech.store.repository.dao.internal;

import za.co.invoketech.store.model.address.Address;
import za.co.invoketech.store.repository.dao.generic.internal.GenericDaoImpl;
import za.co.invoketech.store.service.dao.AddressDao;

import com.google.inject.persist.Transactional;

@Transactional
public class AddressDaoImpl extends GenericDaoImpl<Address, Long> implements AddressDao {
	
	public AddressDaoImpl() {
		super(Address.class);
	}
}
