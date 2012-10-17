package za.co.invoketech.store.service.file;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

public class FileService {

	public static void UploadImage(String path, String productCode) {
		
		File image = new File(path);
		File directory = new File("images/" + productCode);
		directory.getAbsoluteFile().mkdir();
		File newImage = new File(directory + "/image.png");
		
		try {
			Files.copy(image, newImage);
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}