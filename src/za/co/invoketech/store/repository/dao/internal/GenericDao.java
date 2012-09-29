package za.co.invoketech.store.repository.dao.internal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import za.co.invoketech.store.service.dao.Dao;

import com.google.inject.Inject;

public class GenericDao<T extends Serializable, ID> implements Dao<T, ID> {
	
	@Inject
    EntityManager em;

	private Class<T> clazz;
	
	@Override
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public T findById(ID id) {
		return em.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByAttribute(String attribute, String value) {
		List<T> list = (List<T>) em.createQuery("SELECT e FROM " + clazz.getName() + " e WHERE e." + attribute + "=?1").setParameter(1, value).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findEntitiesByAttribute(String attribute, String value) {
		List<T> list = em.createQuery("SELECT e FROM  " + clazz.getName() + " e WHERE e." + attribute + "=?1").setParameter(1, value).getResultList();
        return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findInRange(int start, int end) {
		return em.createQuery("SELECT a FROM " + clazz.getName() + " e").setFirstResult(start).setMaxResults(end).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return em.createQuery("FROM " + clazz.getName()).getResultList();
	}

	@Override
	public void persist(T entity) {
		em.persist(entity);
	}

	@Override
	public void merge(T entity) {
		em.merge(entity);
	}

	@Override
	public void remove(T entity) {
		em.remove(entity);
	}

	@Override
	public void removeById(ID id) {
		final T entity = findById(id);
		em.remove(entity);
	}

	@Override
	public long count() {
		return (long) em.createQuery("SELECT count(e) FROM " + clazz.getName() + " e").getSingleResult();
	}
}
