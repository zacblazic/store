package za.co.invoketech.store.application.util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Hash {
	
	public static byte[] sha2(String password, byte[] salt) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		MessageDigest digest = MessageDigest.getInstance("SHA2");
		digest.reset();
		digest.update(salt);
		return digest.digest(password.getBytes("UTF-8"));
	}

}
