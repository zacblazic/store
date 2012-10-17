package za.co.invoketech.store.application.security;

import za.co.invoketech.store.application.security.PBKDF2;

public class PasswordHash {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String password = "password";
		String saltedHash = PBKDF2.getSaltedHash(password);
		System.out.print(saltedHash);
		
		System.out.println(PBKDF2.check("password", saltedHash) ? "Match" : "No match");	
	}
}
