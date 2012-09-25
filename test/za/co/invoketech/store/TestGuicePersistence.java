package za.co.invoketech.store;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.model.Chassis;
import za.co.invoketech.store.repository.ChassisDao;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class TestGuicePersistence {
	
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	
	public static void main(String[] args) {
		
		injector = Guice.createInjector(new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		
		Chassis chassis = new Chassis();
		chassis.setModel("HAF-X Nvida Edition");
		
		ChassisDao dao = injector.getInstance(ChassisDao.class);
		dao.persist(chassis);		
	}
}
