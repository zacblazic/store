package za.co.invoketech.store.integration.webservices.rest.server.internal;

import org.restlet.resource.ServerResource;

import com.google.inject.Inject;

import za.co.invoketech.store.integration.webservices.rest.server.ProductResource;
import za.co.invoketech.store.model.entity.product.Product;
import za.co.invoketech.store.service.dao.ProductDao;

public class ProductServerResource extends ServerResource implements
		ProductResource {

	@Inject
	private ProductDao dao;
	
	@Override
	public Product retrieve(long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Product p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(long productId) {
		// TODO Auto-generated method stub
		
	}

	


}
