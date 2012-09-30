package za.co.invoketech.store;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.application.config.PersistenceModule;
import za.co.invoketech.store.model.address.PhysicalAddress;
import za.co.invoketech.store.service.dao.AddressDao;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class TestAddressDao {
	
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	
	public static void main(String[] args) {
		
		injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		AddressDao dao = injector.getInstance(AddressDao.class);
		
		PhysicalAddress home = injector.getInstance(PhysicalAddress.class);
		home.setUnitNumber("122");
		home.setStreetName("Athens Road");
		dao.persist(home);
		
		Long homeId = home.getAddressId();
		PhysicalAddress foundHome = (PhysicalAddress)dao.findById(homeId);
		
		System.out.println(foundHome.getUnitNumber() + " " + foundHome.getStreetName());
	}
}
