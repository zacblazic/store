package za.co.invoketech.store.integration.webservices.rest.server;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

import za.co.invoketech.store.domain.model.product.Product;

public interface ProductResource {
	
	@Get
	public Product retrieve(long productId);
	
	@Put
	public void store (Product p);
	
	@Delete
	public void remove(long productId);

}
