
public class TestPasswordHash {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String password = "Kingston58";
		byte[] salt = {4,5,3,5,4,3,8,4,3};
		byte[] hashedPassword = PasswordHash.getPasswordHash(password, salt);
		
		System.out.println("Password: " + password);
		System.out.println("Hashed password: ");
		
		for(int i = 0; i < hashedPassword.length; i++){
			
			System.out.print(hashedPassword[i]);
		}
	}

}
