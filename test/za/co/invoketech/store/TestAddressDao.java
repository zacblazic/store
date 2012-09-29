package za.co.invoketech.store;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.application.config.PersistenceModule;
import za.co.invoketech.store.model.address.Address;
import za.co.invoketech.store.model.address.PhysicalAddress;
import za.co.invoketech.store.service.dao.Dao;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.persist.jpa.JpaPersistModule;

public class TestAddressDao {
	
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	
	public static void main(String[] args) {
		
		injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		
		
		Dao<Address, Long> dao = injector.getInstance(new Key<Dao<Address, Long>>(){});
		
		PhysicalAddress home = injector.getInstance(PhysicalAddress.class);
		home.setUnitNumber("122");
		home.setStreetName("Athens Road");
		
		dao.persist(home);
	}
}
