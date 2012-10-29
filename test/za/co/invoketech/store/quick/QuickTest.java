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
package za.co.invoketech.store.quick;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.account.RoleService;
import za.co.invoketech.store.service.repository.AccountRepository;
import za.co.invoketech.store.service.repository.CustomerRepository;
import za.co.invoketech.store.service.repository.OrderRepository;
import za.co.invoketech.store.service.repository.RoleRepository;

/**
 * @author garethc18@gmail.com (Gareth Conry)
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@SuppressWarnings("unused")
public class QuickTest {



	public QuickTest() {
		Goose.getInjectorForTesting().injectMembers(this);
	}
	
	@Test
	public void test() {
	}
}
