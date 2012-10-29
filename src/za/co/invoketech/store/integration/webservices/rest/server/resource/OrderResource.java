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
package za.co.invoketech.store.integration.webservices.rest.server.resource;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.service.repository.OrderRepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
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
