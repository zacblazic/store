package za.co.invoketech.store.repository;

import javax.persistence.EntityManager;

import za.co.invoketech.store.model.product.software.Game;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

@Transactional
public class GameDao
{
	@Inject
	private EntityManager em;
	
	public Game find(long id) {
		return em.find(Game.class, id);
	}
	
	public void persist(Game entity) {
		em.persist(entity);
	}
}
