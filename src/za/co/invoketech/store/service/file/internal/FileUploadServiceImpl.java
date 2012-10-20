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

package za.co.invoketech.store.service.file.internal;

/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import za.co.invoketech.store.service.file.FileManager;
import za.co.invoketech.store.service.file.FileUploadService;

import com.google.inject.Inject;
import com.google.inject.Singleton;


@Singleton
public class FileUploadServiceImpl implements FileUploadService {

	@Inject
	FileManager fileManager;
	
	public void uploadImage(String path, String productCode, String size) {
		
		File directory = new File(IMAGE_RESOURCE_PATH + productCode);
		
		if(!directory.exists()) {
			directory.mkdirs();
		}
		
		File sourceImage = new File(path);
		File destImage = new File(directory + "/" + size + sourceImage.getName().substring(sourceImage.getName().lastIndexOf('.')));
		
		try {
			com.google.common.io.Files.copy(sourceImage, destImage);
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}  
	
	public void uploadImage(InputStream is, long productId) throws IOException {
		
		File directory = new File(IMAGE_RESOURCE_PATH + productId);
		
		if(!directory.exists()) {
			directory.mkdirs();
		}
		
		// TODO: Image should to the correct directory
		
		Path path = Paths.get(directory.getPath() + "/img_" + productId + "_.jpg");
		Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
	}
}
