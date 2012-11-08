/**
 * Copyright (c) 2012 Invoke Tech
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package za.co.invoketech.store.integration.rest.server;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

import za.co.invoketech.store.integration.rest.resource.OrderResource;
import za.co.invoketech.store.integration.rest.resource.OrdersResource;
import za.co.invoketech.store.integration.rest.resource.TestResource;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
public class InvokeRestServer extends Application {
	
	// For Running server independent of a container
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
	
//	public static void main(String[] args) throws Exception {
//		runServer(8111);
//	}
	
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
