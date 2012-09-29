package za.co.invoketech.store.repository.dao.generic.internal;

import java.util.List;

import javax.persistence.EntityManager;

import za.co.invoketech.store.repository.dao.generic.GenericDao;

import com.google.inject.Inject;

public abstract class GenericDaoImpl<T, ID> implements GenericDao<T, ID> {
	
	@Inject
    protected EntityManager em;

	private Class<T> type;

	@Override
	public T findById(ID id) {
		return em.find(type, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByAttribute(String attribute, String value) {
		List<T> list = (List<T>) em.createQuery("SELECT e FROM " + type.getName() + " e WHERE e." + attribute + "=?1").setParameter(1, value).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findEntitiesByAttribute(String attribute, String value) {
		List<T> list = em.createQuery("SELECT e FROM  " + type.getName() + " e WHERE e." + attribute + "=?1").setParameter(1, value).getResultList();
        return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return em.createQuery("FROM " + type.getName()).getResultList();
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
		return (long) em.createQuery("SELECT count(e) FROM " + type.getName() + " e").getSingleResult();
	}
}
