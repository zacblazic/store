package za.co.invoketech.store;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import za.co.invoketech.store.model.Chassis;

public class TestPersistence {

	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static EntityManagerFactory factory;
	
	public static void main(String[] args) {
		// Get the entity manager from the factory
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createQuery("select c from Chassis c");
		@SuppressWarnings("unchecked")
		List<Chassis> chassisList = q.getResultList();
		
		for(Chassis c : chassisList) {
			System.out.println(c);
		}
		
		System.out.println("Size: " + chassisList.size());
		
		em.getTransaction().begin();
		Chassis chassis = new Chassis();
		chassis.setModel("650D");
		em.persist(chassis);
		em.getTransaction().commit();
		
		em.close();
	}
}
