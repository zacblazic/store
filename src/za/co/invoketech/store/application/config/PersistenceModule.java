package za.co.invoketech.store.application.config;

import za.co.invoketech.store.model.address.Address;
import za.co.invoketech.store.repository.dao.internal.GenericDao;
import za.co.invoketech.store.service.dao.Dao;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class PersistenceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(new TypeLiteral<Dao<Address, Long>>(){}).to(new TypeLiteral<GenericDao<Address, Long>>(){});
	}
}
