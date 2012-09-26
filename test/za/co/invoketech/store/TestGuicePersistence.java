package za.co.invoketech.store;

import java.math.BigDecimal;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.model.product.software.Game;
import za.co.invoketech.store.repository.GameDao;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class TestGuicePersistence {
	
	// Test change
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	
	public static void main(String[] args) {
		
		injector = Guice.createInjector(new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		
//		Chassis chassis = new Chassis();
//		chassis.setModel("HAF-X Nvida Edition");
//		
//		ChassisDao dao = injector.getInstance(ChassisDao.class);
//		dao.persist(chassis);
		
		Game game = new Game();
		game.setDeveloper("DICE");
		game.setPublisher("EA Games");
		game.setDescription("Battlefield 12.0");
		game.setPrice(new BigDecimal(666.12));
		game.setProductCode("GM-EDBF12");
		
		GameDao dao = injector.getInstance(GameDao.class);
		dao.persist(game);
	}
}
