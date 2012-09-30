package za.co.invoketech.store.repository.dao.generic;

import java.util.List;

public interface GenericDao<T, ID> {

    public T findById(final ID id);
    public T findByAttribute(String attribute, String value);
    public List<T> findAll();
    public List<T> findAllByAttribute(String attribute, String value);
    public void persist(final T entity);
    public void merge(final T entity);
    public void remove(final T entity);
    public void removeById(final ID id);
    public long count();
}
