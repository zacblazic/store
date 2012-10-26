package za.co.invoketech.store.rest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ClientResource;

import za.co.invoketech.store.integration.webservices.rest.server.InvokeRestServer;
import za.co.invoketech.store.service.repository.OrderRepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;


public class OrderRestTest {

	@Inject
	private OrderRepository orderRepository;
	
	private static int testPort = 8112;

	@BeforeClass
	public static void startServer () throws Exception {
		InvokeRestServer.runServer(testPort);
	}
	 
	@Test
	public void testGet() throws Exception {
		// Try to retrieve the year from the DateServer.
		String testUrl = "http://localhost:" + testPort + "/rest/order/1";
		ClientResource client = new ClientResource(testUrl);
		String response = client.get().getText();
		// Now check to see if we got the right response.
		
		System.out.println(response);
		System.out.println("------------------------------------------------------------");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonString = gson.toJson(orderRepository.findById(1L));
		
		

		System.out.println(jsonString);
		
		assertEquals("Test GSon", jsonString, response);
	}

}
