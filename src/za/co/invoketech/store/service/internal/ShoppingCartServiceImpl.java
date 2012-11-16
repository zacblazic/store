package za.co.invoketech.store.service.internal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import za.co.invoketech.store.application.exception.CustomerNotFoundException;
import za.co.invoketech.store.application.exception.InvalidStockException;
import za.co.invoketech.store.application.exception.ProductNotFoundException;
import za.co.invoketech.store.application.exception.ShoppingCartItemNotFoundException;
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
import za.co.invoketech.store.domain.model.product.Product;
import za.co.invoketech.store.service.address.AddressService;
import za.co.invoketech.store.service.cart.ShoppingCartService;
import za.co.invoketech.store.service.customer.CustomerService;
import za.co.invoketech.store.service.product.ProductService;
import za.co.invoketech.store.service.repository.OrderRepository;

import com.google.inject.Inject;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Inject
	private ProductService productService;
	
	@Inject
	private CustomerService customerService;
	
	@Inject
	private AddressService addressService;
	
	@Inject
	private OrderRepository orderRepository;

	@Override
	public ShoppingCart customerCart(long customerId) throws CustomerNotFoundException {
		Customer customer = customerService.findCustomerById(customerId);
		ShoppingCart cart = customer.getShoppingCart();
		return cart;
	}

	@Override
	public List<ShoppingCartItem> customerCartItems(long customerId) throws CustomerNotFoundException {
		Customer customer = customerService.findCustomerById(customerId);
		ShoppingCart cart = customer.getShoppingCart();
		return cart.getItems();
	}

	@Override
	public void addToCustomerCart(long customerId, ShoppingCartItem item) throws InvalidStockException, ProductNotFoundException, CustomerNotFoundException {
		Customer customer = null;
		
		if (item.getQuantity() <= 0) {
			throw new InvalidStockException("Quantity Cannot be less than 0");
		}
		
		if (item.getProduct() == null || item.getProduct().getId() == 0) {
			throw new ProductNotFoundException();
		}
		
		if (item.getProduct().getStock() <= item.getQuantity()) {
			throw new InvalidStockException("Not Enough Stock");
		}
		
		customer = customerService.findCustomerById(customerId);
		
		ShoppingCart cart = customer.getShoppingCart();
		cart.addItem(item);
		customer.setShoppingCart(cart);
		
		customerService.updateCustomer(customer);
	}

	@Override
	public void addToCustomerCart(long customerId, long productId,	int quantity) throws InvalidStockException, ProductNotFoundException, CustomerNotFoundException {
		Product product = productService.findProductById(productId);
		
		ShoppingCartItem item = new ShoppingCartItem(product, quantity);
		addToCustomerCart(customerId, item);
	}

	@Override
	public void updateQuantity(long customerId, long shoppingCartItemId, int quantity) 
			throws ShoppingCartItemNotFoundException, CustomerNotFoundException, InvalidStockException, ProductNotFoundException {
		if (shoppingCartItemId > 0) {
			Customer customer = customerService.findCustomerById(customerId);
			boolean found = false;
			ShoppingCartItem foundItem = null;
			
			ShoppingCart cart = customer.getShoppingCart();
			for (ShoppingCartItem item : cart.getItems()) {
				if (item.getId() == shoppingCartItemId) {
					found = true;
					foundItem = item;
					break;
				}
			}
			
			if (found) {
				cart = customer.getShoppingCart();
				cart.removeItem(foundItem);
				customer.setShoppingCart(cart);
				customerService.updateCustomer(customer);
				
				foundItem.setQuantity(quantity);
				addToCustomerCart(customerId, foundItem);
			}
			else throw new ShoppingCartItemNotFoundException();
		}
		else throw new ShoppingCartItemNotFoundException();
	}

	@Override
	public void checkout(long customerId, long addressId, Payment payment, DeliveryMethod method) throws CustomerNotFoundException {

		Customer customer = customerService.findCustomerById(customerId);
		
		ShoppingCart cart = customer.getShoppingCart();
		List<ShoppingCartItem> sciList = cart.getItems();
		
		List<OrderItem> items = new ArrayList<>();
		
		for (ShoppingCartItem sci : sciList) {
			OrderItem newItem = new OrderItem(sci.getProduct(), sci.getProduct().getUnitPrice(), sci.getQuantity());
			items.add(newItem);
		}
		
		Address address = null;
		List<Address> addressList = customer.getAddresses();
		for (Address addr : addressList) {
			if (addr.getId() == addressId) {
				address = addr;
			}
		}
		
		DeliveryAddress delAddr = addressService.createDeliveryAddress(address);
		
		BigDecimal cost = new BigDecimal(0);		
		
		Delivery delivery = new Delivery(method, delAddr, cost);
		
		Order order = new Order(customer, items, payment, delivery);
		orderRepository.persist(order);
		
		List<Order> orders = customer.getOrders();
		orders.add(order);
		
		cart.removeAllItems();
		customer.setShoppingCart(cart);
		customer.setOrders(orders);
		customerService.updateCustomer(customer);
	}

}
