package za.co.invoketech.store.service.file;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

public class FileService {

	final static String IMAGE_RESOURCE_PATH = "res/images";
	
	public static void uploadImage(String path, String productCode, String size) {
		
		File directory = new File(IMAGE_RESOURCE_PATH + "/" + productCode);
		
		if(!directory.exists()) {
			directory.mkdirs();
		}
		
		File sourceImage = new File(path);
		File destImage = new File(directory + "/" + size + sourceImage.getName().substring(sourceImage.getName().lastIndexOf('.')));
		
		try {
			Files.copy(sourceImage, destImage);
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}