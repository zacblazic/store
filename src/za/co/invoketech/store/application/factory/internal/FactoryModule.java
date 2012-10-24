package za.co.invoketech.store.application.factory.internal;

import za.co.invoketech.store.application.factory.CustomerFactory;

import com.google.inject.AbstractModule;

public class FactoryModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CustomerFactory.class).to(CustomerFactoryImpl.class);
	}
}
