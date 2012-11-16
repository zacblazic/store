package za.co.invoketech.store.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.cart.ShoppingCart;
import za.co.invoketech.store.domain.model.cart.ShoppingCartItem;
import za.co.invoketech.store.domain.model.customer.Address;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.model.order.Delivery;
import za.co.invoketech.store.domain.model.order.DeliveryAddress;
import za.co.invoketech.store.domain.model.order.DeliveryMethod;
import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.domain.model.order.OrderItem;
import za.co.invoketech.store.domain.model.order.Payment;
import za.co.invoketech.store.domain.model.order.PaymentMethod;
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

import com.google.inject.Inject;

public class DataTest {
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
	
	public DataTest() {
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
	public void test() throws Exception{
		// Create roles
				Role adminRole = roleService.createRole("Admin");
				Role managerRole = roleService.createRole("Manager");
				Role customerRole = roleService.createRole("Customer");

				// Add roles to lists
				List<Role> adminAndManagerRoles = new ArrayList<Role>();
				adminAndManagerRoles.add(roleService.retrieveRole(adminRole.getId()));
				adminAndManagerRoles.add(roleService.retrieveRole(managerRole.getId()));
				
				List<Role> managerRoles = new ArrayList<Role>();
				managerRoles.add(roleService.retrieveRole(managerRole.getId()));
				
				List<Role> customerRoles = new ArrayList<Role>();
				customerRoles.add(roleService.retrieveRole(customerRole.getId()));
				
				// Create persons
				Person gareth = new Person("Gareth", "Conry", Gender.MALE, "0839491159");
				Person zac = new Person("Zac", "Blazic", Gender.MALE, "0828943000");
				Person carel = new Person("Carel", "Nel", Gender.MALE, "0825003000");
				
				// Create accounts
				accountService.createAccount("admin@invoketech.co.za", "adminpass", adminAndManagerRoles);
				accountService.createAccount("manager@invoketech.co.za", "iammanager",managerRoles);
				accountService.createAccount("gconry@invoketech.co.za", "iamadmin", adminAndManagerRoles);
				accountService.createAccount("zacblazic@invoketech.co.za", "adminpass", adminAndManagerRoles);
				accountService.createAccount("cnel@invoketech.co.za", "adminpass", adminAndManagerRoles);

				Account garethCustAcc = accountService.createAccount("garethc18@gmail.com", "iamuser", customerRoles);
				Account zacCustAcc = accountService.createAccount("zacblazic@gmail.com", "password", customerRoles);
				Account carelCustAcc = accountService.createAccount("a.carel.g.nel@gmail.com", "password", customerRoles);

				Customer garethCustomer = new Customer(gareth, createAddress(), garethCustAcc);
				Customer zacCustomer = new Customer(zac, createAddress(), zacCustAcc);
				Customer carelCustomer = new Customer(carel, createAddress(), carelCustAcc);
				
				customerRepository.persist(garethCustomer);
				customerRepository.persist(zacCustomer);
				customerRepository.persist(carelCustomer);
				
				
				Mouse mouse = new Mouse();
				mouse.setDpi(5600);
				mouse.setButtons(7);
				mouse.setPrice(new BigDecimal(1200));
				mouse.setTitle("Razer Ouroboros");
				mouse.setDiscontinued(false);
				productRepository.persist(mouse);
				
				Mouse newmouse = new Mouse();
				newmouse.setDpi(2500);
				newmouse.setButtons(3);
				newmouse.setPrice(new BigDecimal(500));
				newmouse.setTitle("Coolermaster Sentinel");
				newmouse.setDiscontinued(false);
				productRepository.persist(newmouse);
				
				// Shopping cart for Zac
				ShoppingCart cart = zacCustomer.getShoppingCart();
				cart.addItem(new ShoppingCartItem(mouse));
				cart.addItem(new ShoppingCartItem(newmouse));
				zacCustomer.setShoppingCart(cart);
				customerRepository.merge(zacCustomer);
				
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
	}

}
