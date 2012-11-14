package za.co.invoketech.store.service.cart;

import java.math.BigDecimal;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.application.exception.InvalidStockException;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.cart.ShoppingCart;
import za.co.invoketech.store.domain.model.cart.ShoppingCartItem;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.model.order.DeliveryAddress;
import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.domain.model.product.component.Memory;
import za.co.invoketech.store.domain.shared.AddressType;
import za.co.invoketech.store.domain.shared.Gender;
import za.co.invoketech.store.domain.shared.InternalAddress;
import za.co.invoketech.store.domain.shared.Person;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.account.RoleService;
import za.co.invoketech.store.service.customer.CustomerService;
import za.co.invoketech.store.service.repository.CustomerRepository;
import za.co.invoketech.store.service.repository.OrderRepository;
import za.co.invoketech.store.service.repository.ProductRepository;

import com.google.inject.Injector;
/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
public class ShoppingCartServiceTest {
	private static Injector injector;
	 
	private static RoleService roleService;
	private static AccountService accountService;
	private static CustomerService customerService;
	private static ProductRepository productRepository;
	private static CustomerRepository customerRepository;
	private static ShoppingCartService shoppingCartService;
	private static OrderRepository orderRepository;
	
	private static Person peterPerson;
	private static Account peterCustAcc;
	private static Customer peterCustomer;
	private static Memory memoryInStock;
	private static Memory memoryNoStock;
	
	private static Address createAddress() {
		InternalAddress internalAddress = new InternalAddress.Builder()
			.firstName("Zac")
			.lastName("Blazic")
			.phoneNumber("0828943000")
			.line1("122 Athens Road")
			.line2("Table View")
			.city("Cape Town")
			.postalCode("7441")
			.country("South Africa")
			.addressType(AddressType.PHYSICAL).build();
		return new Address("Home", internalAddress);
	}
	private static DeliveryAddress createDeliveryAddress() {
		InternalAddress internalAddress = new InternalAddress.Builder()
			.firstName("Zac")
			.lastName("Blazic")
			.phoneNumber("0828943000")
			.line1("122 Athens Road")
			.line2("Table View")
			.city("Cape Town")
			.postalCode("7441")
			.country("South Africa")
			.addressType(AddressType.PHYSICAL).build();
		return new DeliveryAddress(internalAddress);
	}

	public ShoppingCartServiceTest() {
		
	}
	
	@BeforeClass
	public static void createData() throws Exception {
		injector = Goose.getInjectorForTesting();
		
		roleService = injector.getInstance(RoleService.class);
		accountService = injector.getInstance(AccountService.class);
		customerService = injector.getInstance(CustomerService.class);
		productRepository = injector.getInstance(ProductRepository.class);
		customerRepository = injector.getInstance(CustomerRepository.class);
		shoppingCartService = injector.getInstance(ShoppingCartService.class);
		orderRepository = injector.getInstance(OrderRepository.class);
		
		/* Create Data */
		// Customer Data		
		peterPerson = new Person("Peter", "Parker", Gender.MALE, "0833512456");
		peterCustAcc = new Account("pparker@gmail.com", "spiderman");
		peterCustomer = customerService.createCustomer(peterPerson, createAddress(), peterCustAcc);
		peterCustAcc = peterCustomer.getAccount();
		
		// Product Data		
		memoryInStock = new Memory();
		memoryInStock.setTitle("Corsair Vengeance LP 8GB");
		memoryInStock.setPrice(new BigDecimal(478));
		memoryInStock.setStock(5);
		memoryInStock.setFrequency("1600");
		memoryInStock.setLatency("9-9-9-24");
		memoryInStock.setModules(2);
		
		productRepository.persist(memoryInStock);

		memoryNoStock = new Memory();
		memoryNoStock.setTitle("Corsair Vengeance LP 16GB");
		memoryNoStock.setPrice(new BigDecimal(478));
		memoryNoStock.setStock(0);
		memoryNoStock.setFrequency("1600");
		memoryNoStock.setLatency("9-9-9-24");
		memoryNoStock.setModules(4);		

		productRepository.persist(memoryNoStock);
	}
	
	@AfterClass
	public static void removeData() throws Exception {
		customerRepository.remove(peterCustomer);
		peterCustAcc.setCustomer(null);
		accountService.removeAccount(peterCustAcc);
		productRepository.remove(memoryInStock);
		productRepository.remove(memoryNoStock);
	}
	
	@After
	public void afterTest() {
		ShoppingCart cart = peterCustomer.getShoppingCart();
		cart.removeAllItems();
		
		if (peterCustomer.getOrders().size() != 0) {
			for (Order order : peterCustomer.getOrders()) {
				orderRepository.remove(order);
			}
		}
	}

	@Test
	public void testAddProductToCartWithStock() throws Exception{
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(memoryInStock);
		shoppingCartService.addToCustomerCart(peterCustomer.getId(), shoppingCartItem);
				
		boolean incart = false;
		
		ShoppingCart cart = peterCustomer.getShoppingCart();
		List<ShoppingCartItem> itemsInCart = cart.getItems();
		for (ShoppingCartItem item : itemsInCart) {
			if (item.getId() == memoryInStock.getId()){
				incart = true;
				break;
			}
		}
		
		Assert.assertTrue(incart);
	}

	@Test (expected=InvalidStockException.class)
	public void testAddProductToCartNoStock() throws Exception{
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(memoryNoStock);
		shoppingCartService.addToCustomerCart(peterCustomer.getId(), shoppingCartItem);
		
		Assert.fail("No Exception Thrown");
	}
	
	@Test
	public void testUpdateQtyValid() throws Exception{
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(memoryInStock);
		shoppingCartService.addToCustomerCart(peterCustomer.getId(), shoppingCartItem);
		
		long itemId = 0;
		peterCustomer = customerService.findCustomerById(peterCustomer.getId());
		ShoppingCart cart = peterCustomer.getShoppingCart();
		List<ShoppingCartItem> sci = cart.getItems();
		
		
		
		shoppingCartService.updateQuantity(peterCustomer.getId(), shoppingCartItem.getId(), 3);
		
		//ShoppingCart cart = peterCustomer.getShoppingCart();
		List<ShoppingCartItem> items = cart.getItems();
		Assert.assertTrue(items.get(0).getQuantity() == 3);
	}

	@Test (expected=InvalidStockException.class)
	public void testUpdateQtyInvalid() throws Exception{
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(memoryInStock);
		shoppingCartService.addToCustomerCart(peterCustomer.getId(), shoppingCartItem);
		
		shoppingCartService.updateQuantity(peterCustomer.getId(), shoppingCartItem.getId(), 6);
		
		Assert.fail("No Exception Thrown");
	}
	
	@Test
	@Ignore
	public void testCheckout() throws Exception{
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(memoryInStock, 1);
		shoppingCartService.addToCustomerCart(peterCustomer.getId(), shoppingCartItem);
		
		shoppingCartService.checkout(peterCustomer.getId(), peterCustomer.getPrimaryAddress().getId());
		
		if (peterCustomer.getOrders().size() != 0) {
			for (Order order : peterCustomer.getOrders()) {
				Assert.assertTrue(order.getItems().get(0).getProduct().equals(memoryInStock));
			}
		}
		else {
			Assert.fail("Order Not Created");
		}
	}
}
