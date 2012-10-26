package za.co.invoketech.store.integration.webservices.rest.server.resource;

import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.service.repository.OrderRepository;

import com.google.inject.Inject;

public class OrdersResource extends ServerResource {
	@Inject
	private OrderRepository orderRepository;
	
	@Get
	public List<Order> getOrder(){
		System.out.println("Hello: ");
		List<Order> orders;
		orders = orderRepository.findAll();
		
		return orders;		
	}
}
