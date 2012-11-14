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
	
	public String uploadImage(String path, String productId) {
		
		File directory = new File(fileManager.getApplicationRoot() + IMAGE_RESOURCE_PATH + productId);
		
		if(!directory.exists()) {
			directory.mkdirs();
		}
		
		File sourceImage = new File(path);
		File destImage = new File(directory + "/img_" + productId + "_1" + sourceImage.getName().substring(sourceImage.getName().lastIndexOf('.')));
		
		System.out.println("Source - " + sourceImage.getAbsolutePath());
		System.out.println("Destin - " + destImage.getAbsolutePath());
		
		try {
			com.google.common.io.Files.copy(sourceImage, destImage);
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		return destImage.getAbsolutePath();
	}  
	
	public void uploadImage(InputStream is, String extension, long productId) throws IOException {
		File directory = new File(fileManager.getApplicationRoot() + IMAGE_RESOURCE_PATH + productId);
		
		if(!directory.exists()) {
			directory.mkdirs();
			Path path = Paths.get(directory.getPath() + "/img_" + productId + "_1." + extension);
			System.out.println(path);
			Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
		}
		else {
			File[] files = directory.listFiles();			
			
			String currentFile;
			int currentFileIteration;
			
			if(files.length > 0)
			{
				boolean created = false;
				files = sortFileArray(files);
				
				
				for(int i = 0; i < files.length && !created; i++) {
					currentFile = files[i].getName();
					currentFileIteration = Integer.parseInt(currentFile.substring(currentFile.lastIndexOf('_') + 1, currentFile.lastIndexOf('_') + 2));
					
					if( currentFileIteration != (i+1) ) {
						Path path = Paths.get(directory.getPath() + "/img_" + productId + "_" + (i + 1) + "." + extension);
						Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
						created = true;
					}
				}
				
				if(!created) {
					Path path = Paths.get(directory.getPath() + "/img_" + productId + "_" + (files.length + 1) + "." + extension);
					Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
				}
			}
			else {
				Path path = Paths.get(directory.getPath() + "/img_" + productId + "_1." + extension);
				Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
			}
		}
	}
	
	private File[] sortFileArray (File[] files) {
		
		for(int out = 0; out < files.length; out++) {
			for(int in = 0; in < out; in++) {
				if(files[in].getName().compareTo(files[in + 1].getName()) > 0) {
					File temp = files[in];
					files[in] = files[in + 1];
					files[in + 1] = temp;
				}
			}
		}
		return files;
	}
}
