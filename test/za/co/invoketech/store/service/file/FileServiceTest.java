package za.co.invoketech.store.service.file;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

public class FileServiceTest {

	@Test
	public void testUploadImage() {
		
		System.out.println(System.getProperty("user.dir").toString());
		
		String size = "large";
		//String path = "C:/Users/Orion/Pictures/dhx-ddr3-angled - Copy.png";
		String productCode = "mem123";
		
		//FileService.uploadImage(path, productCode, size);
		
		File image = new File("res/images/" + productCode + "/" + size + ".png");
		
		Assert.assertTrue(image.getAbsolutePath() + " does not exist", image.exists());
	}
}
