package za.co.invoketech.store.service.file;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

import za.co.invoketech.store.application.config.Goose;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class FileServiceTest {

	@Inject
	FileUploadService fileUploadService;
	
	@Test
	public void testUploadImage() {
		Injector injector = Goose.getInjectorForTesting();
		fileUploadService = injector.getInstance(FileUploadService.class);
		
		String path = "C:/Users/Orion/Pictures/dhx-ddr3-angled - Copy.png";
		String productCode = "mem123";
		
		String newPath = fileUploadService.uploadImage(path, productCode);
		
		File image = new File(newPath);
		
		Assert.assertTrue(image.getAbsolutePath() + " does not exist", image.exists());
	}
}
