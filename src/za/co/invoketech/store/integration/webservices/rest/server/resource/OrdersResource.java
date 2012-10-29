package za.co.invoketech.store.integration.webservices.rest.server.resource;

import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.service.repository.OrderRepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;

public class OrdersResource extends ServerResource {
	@Inject
	private OrderRepository orderRepository;
	
	public OrdersResource() {
		Goose.getInjectorForTesting().injectMembers(this);
	}
	
	@Get
	public String getOrders() {
		List<Order> orders;
		orders = orderRepository.findAll();
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		String jse = gson.toJson(orders);
		
		return jse;		
	}
}
