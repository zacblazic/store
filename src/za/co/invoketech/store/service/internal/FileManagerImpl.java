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

package za.co.invoketech.store.service.internal;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import za.co.invoketech.store.service.file.FileManager;

import com.google.inject.Singleton;

/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 */

@Singleton
public class FileManagerImpl implements FileManager {

	private String applicationRoot;
	
	public String getApplicationRoot() {
	
		if(applicationRoot == null) {
			ServletContext context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
			applicationRoot = context.getRealPath("");
		}
		
		return applicationRoot;
	}
}
