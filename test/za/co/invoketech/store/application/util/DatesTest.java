package za.co.invoketech.store.application.util;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

public class DatesTest {

	@Test
	public void testCurrentDate() throws InterruptedException {
		Date now = Dates.now();
		Thread.sleep(1000);
		Date later = Dates.now();
		Assert.assertTrue(now.compareTo(later) < 0);
	}
}
