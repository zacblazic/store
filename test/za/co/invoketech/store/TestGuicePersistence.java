package za.co.invoketech.store;

import java.math.BigDecimal;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.model.product.software.Game;
import za.co.invoketech.store.repository.ProductDao;

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
		
		ProductDao prodDao = injector.getInstance(ProductDao.class);
		prodDao.persist(game);
		
		Game game2 = new Game();
		game2.setDeveloper("Grim");
		game2.setPublisher("Ubisoft");
		game2.setDescription("Ghost Recon 666");
		game2.setPrice(new BigDecimal(450.25));
		game2.setProductCode("GM-UGGR666");
		
		prodDao.persist(game2);
	}
}
