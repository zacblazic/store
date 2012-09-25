package za.co.invoketech.store.repository;

import javax.persistence.EntityManager;

import za.co.invoketech.store.model.Chassis;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

@Transactional
public class ChassisDao {

	@Inject
	private EntityManager em;
	
	public Chassis find(long id) {
		return em.find(Chassis.class, id);
	}
	
	public void persist(Chassis entity) {
		em.persist(entity);
	}
}
