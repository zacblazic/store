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

import za.co.invoketech.store.service.repository.AccountRepository;
import za.co.invoketech.store.service.repository.CustomerRepository;
import za.co.invoketech.store.service.repository.InvoiceRepository;
import za.co.invoketech.store.service.repository.OrderRepository;
import za.co.invoketech.store.service.repository.ProductRepository;
import za.co.invoketech.store.service.repository.RoleRepository;

import com.google.inject.AbstractModule;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */

public class PersistenceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AccountRepository.class).to(AccountRepositoryImpl.class);
		bind(CustomerRepository.class).to(CustomerRepositoryImpl.class);
		bind(InvoiceRepository.class).to(InvoiceRepositoryImpl.class);
		bind(OrderRepository.class).to(OrderRepositoryImpl.class);
		bind(ProductRepository.class).to(ProductRepositoryImpl.class);
		bind(RoleRepository.class).to(RoleRepositoryImpl.class);
	}
}
