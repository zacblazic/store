package za.co.invoketech.store.application.config;

import za.co.invoketech.store.repository.dao.internal.AddressDaoImpl;
import za.co.invoketech.store.service.dao.AddressDao;

import com.google.inject.AbstractModule;

public class PersistenceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AddressDao.class).to(AddressDaoImpl.class);		
	}
}
