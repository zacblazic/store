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

package za.co.invoketech.store.application.config;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */

public class ApplicationInitializer {
	
	@Inject
	public ApplicationInitializer(PersistService service) {
		service.start();
	}
}
