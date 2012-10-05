package za.co.invoketech.store.application.util;

public class TestSCrypt {

	public static void main(String[] args) {

		String password = "password";
		int cpuCost = 16384;
        int memoryCost = 64;
        int parallelization = 4;
        
        String hashedPassword = SCryptUtil.scrypt(password, cpuCost, memoryCost, parallelization);
        
        System.out.println("Password: " + password);
        System.out.println("Hashed password: " + hashedPassword);
        System.out.println("Check status: " + SCryptUtil.check(password, hashedPassword));
	}
}
