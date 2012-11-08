package za.co.invoketech.store.rest;

import java.lang.reflect.Type;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ClientResource;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.integration.rest.server.InvokeRestServer;
import za.co.invoketech.store.service.repository.OrderRepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;


public class OrderRestTest {

	@Inject
	private OrderRepository orderRepository;
	
	private static int testPort = 8112;
	
	public OrderRestTest() {
		Goose.getInjectorForTesting().injectMembers(this);
	}

	@BeforeClass
	public static void startServer () throws Exception {
		InvokeRestServer.runServer(testPort);
	}
	 
	@Test
	public void testGetOrder() throws Exception {
		// Try to retrieve the year from the DateServer.
		String testUrl = "http://localhost:" + testPort + "/rest/order/1";
		ClientResource client = new ClientResource(testUrl);
		String response = client.get().getText();
		// Now check to see if we got the right response.
		
		System.out.println(response);
		System.out.println("------------------------------------------------------------");
		
		Order order = orderRepository.findById(1L);
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		String jse =  gson.toJson(order);
		System.out.println(jse);
		
		Assert.assertEquals("Test GSon", jse.toString(), response);
		
		Order jsonOrder = gson.fromJson(response, Order.class);
		Assert.assertTrue(order.getId() == jsonOrder.getId());
	}
	 
	@Test
	public void testGetOrders() throws Exception {
		// Try to retrieve the year from the DateServer.
		String testUrl = "http://localhost:" + testPort + "/rest/orders";
		ClientResource client = new ClientResource(testUrl);
		String response = client.get().getText();
		// Now check to see if we got the right response.
		
		System.out.println(response);
		System.out.println("------------------------------------------------------------");
		
		List<Order> orders = orderRepository.findAll();
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		String jse =  gson.toJson(orders);
		System.out.println(jse);
		
		Assert.assertEquals("Test GSon", jse.toString(), response);
		
		Type type = new TypeToken<List<Order>>(){}.getType();
		
		List<Order> jsonOrders = gson.fromJson(response, type);
		Assert.assertTrue(orders.get(0).getId() == jsonOrders.get(0).getId());
	}

}
