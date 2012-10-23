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
package za.co.invoketech.store.integration.webservices.rest.server.internal;

import org.restlet.resource.ServerResource;

import com.google.inject.Inject;

import za.co.invoketech.store.domain.model.product.Product;
import za.co.invoketech.store.integration.webservices.rest.server.ProductResource;
import za.co.invoketech.store.service.repository.ProductRepository;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
public class ProductServerResource extends ServerResource implements
		ProductResource {

	@Inject
	private ProductRepository dao;
	
	@Override
	public Product retrieve(long productId) {
		Product product = dao.findById(productId);
		return product;
	}

	@Override
	public void store(Product p) {
		try
		{
			dao.persist(p);
		}
		catch (Exception ex)
		{
			try 
			{
				dao.merge(p);
			} 
			catch (Exception e) 
			{
				System.err.println("Error: \n" + ex.getMessage() + "\n" + e.getMessage());
			}
		}
	}

	@Override
	public void remove(long productId) {
		dao.removeById(productId);		
	}

	


}
