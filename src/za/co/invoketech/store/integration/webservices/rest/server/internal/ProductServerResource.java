package za.co.invoketech.store.integration.webservices.rest.server.internal;

import org.restlet.resource.ServerResource;

import com.google.inject.Inject;

import za.co.invoketech.store.domain.model.product.Product;
import za.co.invoketech.store.integration.webservices.rest.server.ProductResource;
import za.co.invoketech.store.service.repository.ProductRepository;

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
