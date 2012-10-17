package za.co.invoketech.store.service.file;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

public class FileServiceTest {

	@Test
	public void testUploadImage() {
		String path = "C:/Users/Orion/Pictures/dhx-ddr3-angled - Copy.png";
		String productCode = "mem123";
		
		FileService.UploadImage(path, productCode);
		
		File image = new File("images/" + productCode + "/image.png");
		
		Assert.assertTrue(image.getAbsolutePath() + " does not exist", image.exists());
	}
}
