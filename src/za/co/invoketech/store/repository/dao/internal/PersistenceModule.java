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

package za.co.invoketech.store.repository.dao.internal;

import za.co.invoketech.store.service.dao.AccountDao;
import za.co.invoketech.store.service.dao.CustomerDao;
import za.co.invoketech.store.service.dao.InvoiceDao;
import za.co.invoketech.store.service.dao.OrderDao;
import za.co.invoketech.store.service.dao.ProductDao;
import za.co.invoketech.store.service.dao.RoleDao;

import com.google.inject.AbstractModule;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */

public class PersistenceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AccountDao.class).to(AccountDaoImpl.class);
		bind(CustomerDao.class).to(CustomerDaoImpl.class);
		bind(InvoiceDao.class).to(InvoiceDaoImpl.class);
		bind(OrderDao.class).to(OrderDaoImpl.class);
		bind(ProductDao.class).to(ProductDaoImpl.class);
		bind(RoleDao.class).to(RoleDaoImpl.class);
	}
}
