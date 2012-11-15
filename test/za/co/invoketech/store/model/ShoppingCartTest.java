package za.co.invoketech.store.model;

import java.math.BigDecimal;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.cart.ShoppingCart;
import za.co.invoketech.store.domain.model.cart.ShoppingCartItem;
import za.co.invoketech.store.domain.model.product.component.Memory;
import za.co.invoketech.store.service.repository.ProductRepository;

import com.google.inject.Inject;

public class ShoppingCartTest {

	@Inject private ProductRepository productRepository;
	
	private ShoppingCart cart;
	private Memory memory;
	
	public ShoppingCartTest() {
		Goose.getInjectorForTesting().injectMembers(this);
	}
	
	@Before
	public void setUp() {
		// Create cart
		cart = new ShoppingCart(new ArrayList<ShoppingCartItem>());
		
		// Create product
		memory = new Memory();
		memory.setTitle("Corsair Vengeance LP 8GB");
		memory.setPrice(new BigDecimal(478));
		memory.setStock(5);
		memory.setFrequency("1600");
		memory.setLatency("9-9-9-24");
		memory.setModules(2);
		
		productRepository.persist(memory);
	}
	
	@Test
	public void testCreateShopppingCartItem() {
		ShoppingCartItem item = new ShoppingCartItem(memory);
		Assert.assertEquals(item.getQuantity(), 1);
	}
	
	@Test
	public void testAddShoppingCartItem() {
		ShoppingCartItem item = new ShoppingCartItem(memory);
		boolean added = cart.addItem(item);
		
		Assert.assertTrue(added);
		Assert.assertEquals(cart.getItemCount(), 1);
	}
	
	@After
	public void cleanUp() {
		productRepository.remove(memory);
	}
}
