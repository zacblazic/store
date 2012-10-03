import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordHash {
	
	public static byte[] getPasswordHash(String password, byte[] salt) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.reset();
		digest.update(salt);
		return digest.digest(password.getBytes("UTF-8"));
	}

}
