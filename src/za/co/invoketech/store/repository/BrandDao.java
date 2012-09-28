package za.co.invoketech.store.repository;

import javax.persistence.EntityManager;

import za.co.invoketech.store.model.product.Brand;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

@Transactional
public class BrandDao {
	@Inject
	private EntityManager em;
	
	public Brand find(long id) {
		return em.find(Brand.class, id);
	}
	
	public void persist(Brand entity) {
		em.persist(entity);
	}
}
