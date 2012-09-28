package za.co.invoketech.store.service.repository;

import java.io.Serializable;
import java.util.List;

public interface Repository<T extends Serializable, ID> {
	
	void setClazz(final Class<T> clazz);
    public T findById(final ID id);
    public T findByAttribute(String attribute, String value);
    public List<T> findEntitiesByAttribute(String attribute, String value);
    public List<T> findInRange(int start, int end);
    public List<T> findAll();
    public void persist(final T entity);
    public void merge(final T entity);
    public void remove(final T entity);
    public void removeById(final ID id);
    public long count();
}
