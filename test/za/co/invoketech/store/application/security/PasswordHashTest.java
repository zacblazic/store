package za.co.invoketech.store.application.security;

import junit.framework.Assert;

import org.junit.Test;

public class PasswordHashTest {

	@Test
	public void test() throws Exception {
		String password = "password";
		String saltedHash = PBKDF2.getSaltedHash(password);
		
		Assert.assertTrue(PBKDF2.check(password, saltedHash));
	}

}
