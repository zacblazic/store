package za.co.invoketech.store.service.file.internal;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import za.co.invoketech.store.service.file.FileUploadService;

import com.google.inject.Singleton;

@Singleton
public class FileUploadServiceImpl implements FileUploadService {

	public void uploadImage(String path, String productCode, String size) {
		
		File directory = new File(IMAGE_RESOURCE_PATH + "/" + productCode);
		
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
		
		File directory = new File(IMAGE_RESOURCE_PATH + "/" + productId);
		
		if(!directory.exists()) {
			directory.mkdirs();
		}
		
		// TODO: Image should to the correct directory
		
		Path path = Paths.get(directory.getPath() + "/test.png");
		Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
	}
}
