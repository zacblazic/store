package za.co.invoketech.store.application.config;

import za.co.invoketech.store.model.address.Address;
import za.co.invoketech.store.model.product.Product;
import za.co.invoketech.store.repository.dao.GenericDao;
import za.co.invoketech.store.repository.dao.internal.EclipseLinkGenericDao;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class PersistenceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(new TypeLiteral<GenericDao<Address, Long>>(){}).to(new TypeLiteral<EclipseLinkGenericDao<Address, Long>>(){});
		bind(new TypeLiteral<GenericDao<Product, Long>>(){}).to(new TypeLiteral<EclipseLinkGenericDao<Product, Long>>(){});
	}
}
