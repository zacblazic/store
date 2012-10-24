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

package za.co.invoketech.store.persistence.dao;

import java.util.List;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
public interface GenericDao<T, ID> {

    public T findById(final ID id);
    public T findByAttribute(String attribute, String value);
    public List<T> findAll();
    public List<T> findAllByAttribute(String attribute, String value);
    public void persist(final T entity);
    public T merge(final T entity);
    public void remove(final T entity);
    public void removeById(final ID id);
    public long count();
}
