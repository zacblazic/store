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

package za.co.invoketech.store.presentation;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.service.file.FileUploadService;

import com.google.inject.Inject;

/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 */

@ManagedBean
public class FileUploadBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FileUploadService fileUploadService;
	private long productId;
	private UploadedFile file;
	
	public FileUploadBean() {
		Goose.getInjector().injectMembers(this);
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public void upload() {
		
		if(file != null && productId != 0) {
			
			try {
				String extension = file.getFileName().substring(file.getFileName().lastIndexOf('.')+1);
				fileUploadService.uploadImage(file.getInputstream(), extension, productId);
			} catch (IOException e) {
				System.out.println(e);
			}

			FacesMessage msg = new FacesMessage("Succesful, " + file.getFileName() + " has been uploaded.", "");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
}
