package za.co.invoketech.store.repository.dao.internal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public class EclipseLinkGenericDao<> implements GenericDao<> {

	private Class<T> clazz;
    
    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    EntityManager em;

    @Override
    public void setClazz(final Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T findById(final Long id) {
        return em.find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("FROM " + clazz.getName()).getResultList();
    }

    @Override
    public void persist(final T entity) { 
        em.persist(entity);
    }

    @Override
    public void merge(final T entity) {
        em.merge(entity);
    }

    @Override
    public void remove(final T entity) {
        em.remove(entity);
    }

    @Override
    public void removeById(final Long entityId) {
        final T entity = findById(entityId);
        remove(entity);
    }

    @Override
    public List<T> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a FROM " + clazz.getName() + " e").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(e) FROM " + clazz.getName() + " e").getSingleResult();
    }

    @Override
    public T getByPropertyName(String name, String value) {
        List<T> list = em.createQuery("SELECT e FROM " + clazz.getName() + " e WHERE e." + name + "=?1").setParameter(1, value).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<T> getEntitiesByProperName(String name, String value) {
        List<T> list = em.createQuery("SELECT e FROM  " + clazz.getName() + " e WHERE e." + name + "=?1").setParameter(1, value).getResultList();
        return list;
    }
}
