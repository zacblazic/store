package za.co.invoketech.store.integration.webservices.rest.server;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

import za.co.invoketech.store.integration.webservices.rest.server.resource.OrderResource;
import za.co.invoketech.store.integration.webservices.rest.server.resource.OrdersResource;
import za.co.invoketech.store.integration.webservices.rest.server.resource.TestResource;

public class InvokeRestServer extends Application {
	
	public static void runServer(int port) throws Exception {
		// Create a component.  
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, port);
		// Create an application (this class).
		Application application = new InvokeRestServer();
		// Attach the application to the component with a defined contextRoot.
		String contextRoot = "/rest";
		component.getDefaultHost().attach(contextRoot, application);
		component.start();
	}
	
	public static void main(String[] args) throws Exception {
		runServer(8111);
	}
	
	@Override
	public Restlet createInboundRoot() {
		// Create a router restlet.
		Router router = new Router(getContext());
		// Attach the resources to the router.
		router.attach("/orders", OrdersResource.class);
		router.attach("/order/{orderId}", OrderResource.class);
		router.attach("/test/{word}", TestResource.class);
		// Return the root router
		return router;
	}
	
}
