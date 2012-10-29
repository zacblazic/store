package za.co.invoketech.store.integration.webservices.rest.server.resource;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.service.repository.OrderRepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;

public class OrderResource extends ServerResource {
	@Inject
	private OrderRepository orderRepository;
	
	public OrderResource() {
		Goose.getInjectorForTesting().injectMembers(this);
	}
	
	@Get
	public String getOrder() {
		Order order;
		long orderId = Long.valueOf((String) this.getRequestAttributes().get("orderId"));
		order = orderRepository.findById(orderId);
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		String jse = gson.toJson(order);		
		
		return jse;
	}
}
