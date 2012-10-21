package za.co.invoketech.store.service.file;

import java.io.IOException;
import java.io.InputStream;

public interface FileUploadService {

	final static String IMAGE_RESOURCE_PATH = "/images/";
	
	void uploadImage(String path, String productCode, String size);
	void uploadImage(InputStream is, String extension, long productId) throws IOException;
}