package za.co.invoketech.store.json;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.model.order.Delivery;
import za.co.invoketech.store.domain.model.order.DeliveryAddress;
import za.co.invoketech.store.domain.model.order.DeliveryMethod;
import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.domain.model.order.OrderItem;
import za.co.invoketech.store.domain.model.order.Payment;
import za.co.invoketech.store.domain.model.order.PaymentMethod;
import za.co.invoketech.store.domain.model.product.Brand;
import za.co.invoketech.store.domain.model.product.peripheral.Mouse;
import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.domain.shared.AddressType;
import za.co.invoketech.store.domain.shared.Gender;
import za.co.invoketech.store.domain.shared.InternalAddress;
import za.co.invoketech.store.domain.shared.Person;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.account.RoleService;
import za.co.invoketech.store.service.repository.CustomerRepository;
import za.co.invoketech.store.service.repository.OrderRepository;
import za.co.invoketech.store.service.repository.ProductRepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;

public class OrderJsonTest {

	@Inject
	private AccountService accountService;
	
	@Inject
	private RoleService roleService;
	
	@Inject
	private CustomerRepository customerRepository;
	
	@Inject
	private ProductRepository productRepository;
	
	@Inject
	private OrderRepository orderRepository;
	
	public OrderJsonTest() {
		Goose.getInjectorForTesting().injectMembers(this);
	}

	private Address createAddress() {
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
	private DeliveryAddress createDeliveryAddress() {
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
	
	@Test
	public void test() throws Exception {

		Role customerRole = roleService.createRole("Customer");
		List<Role> customerRoles = new ArrayList<Role>();
		customerRoles.add(roleService.retrieveRole(customerRole.getId()));
		
		Person gareth = new Person("Gareth", "Conry", Gender.MALE, "0839491159");
		Account garethCustAcc = accountService.createAccount("garethc18@gmail.com", "iamuser", customerRoles);
		Customer garethCustomer = new Customer(gareth, createAddress(), garethCustAcc);
		
		customerRepository.persist(garethCustomer);
		
		Mouse mouse = new Mouse();
		mouse.setDpi(5600);
		mouse.setButtons(7);
		mouse.setPrice(new BigDecimal(1200));
		mouse.setTitle("Ouroboros");
		mouse.setBrand(new Brand("Razer"));
		mouse.setDiscontinued(false);
		
		productRepository.persist(mouse);
		
		Mouse newmouse = new Mouse();
		newmouse.setDpi(2500);
		newmouse.setButtons(3);
		newmouse.setPrice(new BigDecimal(500));
		newmouse.setTitle("Sentinel");
		newmouse.setBrand(new Brand("Coolermaster"));
		newmouse.setDiscontinued(false);
		
		productRepository.persist(newmouse);

		OrderItem item1 = new OrderItem(mouse, mouse.getUnitPrice());
		OrderItem item2 = new OrderItem(newmouse, newmouse.getUnitPrice());
		
		List<OrderItem> items = new ArrayList<>();
		items.add(item1);
		items.add(item2);
		
		Delivery delivery = new Delivery(DeliveryMethod.COLLECT, createDeliveryAddress(), new BigDecimal(0));
		Order order = new Order(garethCustomer, items, new Payment(PaymentMethod.CASH), delivery);
		
		orderRepository.persist(order);
		garethCustomer.getOrders().add(order);
		customerRepository.merge(garethCustomer);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonString = gson.toJson(order);
		System.out.println(jsonString);
		
		System.out.println("======================================");
		
		String newStr = gson.toJson(orderRepository.findById(order.getId()));
		System.out.println(newStr);
		
		Assert.assertEquals(jsonString, newStr);
	}

}
