package za.co.invoketech.store.repository.dao;

import static org.junit.Assert.fail;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.model.entity.product.Brand;
import za.co.invoketech.store.model.entity.product.Product;
import za.co.invoketech.store.model.entity.product.peripheral.Mouse;
import za.co.invoketech.store.repository.dao.internal.PersistenceModule;
import za.co.invoketech.store.service.dao.ProductDao;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class ProductDaoTest {
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	private static ProductDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		dao = injector.getInstance(ProductDao.class);
	}

	@Test
	public void test() {
		// Create
		Mouse mouse = injector.getInstance(Mouse.class);
		mouse.setDpi(5600);
		mouse.setButtons(7);
		mouse.setPrice(new BigDecimal(1200.00));
		mouse.setDescription("Ouroboros");
		mouse.setBrand(new Brand("Razer"));
		mouse.setProductCode("Mo-RO");
		mouse.setDiscontinued(false);
		
		dao.persist(mouse);
		Assert.assertTrue(true);
		
		// Read
		Product p =  dao.findById(mouse.getId());		
		if (p instanceof Mouse)
		{
			System.out.println("Product is a Mouse");
			Mouse mo = (Mouse)p;
			Assert.assertTrue(mo.getButtons() == mouse.getButtons());
		}
		else fail("Nope");
		
		// Update
		
		
		// Delete
		
		
	}

}
