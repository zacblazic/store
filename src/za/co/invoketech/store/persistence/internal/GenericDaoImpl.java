/**
 * Copyright (c) 2012 Invoke Tech
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package za.co.invoketech.store.persistence.internal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import za.co.invoketech.store.service.dao.GenericDao;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Generic data access object that conforms to the JPA 2.0 specification.
 * 
 * @author zacblazic@gmail.com (Zac Blazic)
 */
abstract class GenericDaoImpl<T, ID> implements GenericDao<T, ID> {
	
	@Inject
    private Provider<EntityManager> entityManagerProvider;
	
	private final Class<T> type;
	
	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public T findById(ID id) {
		return getEntityManager().find(type, id);
	}

	@Override
	public T findByAttribute(String attribute, String value) {
		String sql = "SELECT e FROM " + type.getSimpleName() + " e WHERE e." + attribute + " = :attribute";
		TypedQuery<T> query = getEntityManager().createQuery(sql, type).setParameter("attribute", value);
		List<T> results = query.getResultList();
		
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public List<T> findAll() {
		String sql = "SELECT e FROM " + type.getSimpleName() + " e";
		TypedQuery<T> query = getEntityManager().createQuery(sql, type);
		
		return query.getResultList();
	}
	
	@Override
	public List<T> findAllByAttribute(String attribute, String value) {
		String sql = "SELECT e FROM " + type.getSimpleName() + " e WHERE e." + attribute + " = :attribute";
		TypedQuery<T> query = getEntityManager().createQuery(sql, type).setParameter("attribute", value);
		
		return query.getResultList();
	}

	@Override
	public void persist(T entity) {
		getEntityManager().persist(entity);
	}

	@Override
	public T merge(T entity) {
		return getEntityManager().merge(entity);
	}

	@Override
	public void remove(T entity) {
		getEntityManager().remove(merge(entity));
	}

	@Override
	public void removeById(ID id) {
		final T entity = findById(id);
		getEntityManager().remove(entity);
	}

	@Override
	public long count() {
		String sql = "SELECT COUNT(e) FROM " + type.getSimpleName() + " e";
		TypedQuery<Long> query = getEntityManager().createQuery(sql, Long.class);
		
		return query.getSingleResult().longValue();
	}
	
	protected EntityManager getEntityManager() {
		return entityManagerProvider.get();
	}
}
