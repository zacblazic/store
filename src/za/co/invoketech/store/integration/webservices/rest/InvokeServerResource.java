package za.co.invoketech.store.integration.webservices.rest;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class InvokeServerResource extends ServerResource{
	
	public static void main(String[] args) throws Exception {
		new Server(Protocol.HTTP, 8182, InvokeServerResource.class).start();
	}
	
	@Get
	public String toString()
	{
		return "<h1>Welcome to invoketech</h1>\nInvoking Awesomeness Through Technology";
	}
}
