package za.co.invoketech.store.repository;

import javax.persistence.EntityManager;

import za.co.invoketech.store.model.product.Product;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

@Transactional
public class ProductDao {
	@Inject
	private EntityManager em;
	
	public Product find(long id) {
		return em.find(Product.class, id);
	}
	
	public void persist(Product entity) {
		em.persist(entity);
	}
}
