package za.co.invoketech.store.application.util;

public class TestSCrypt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String password = "mushki12";
		int cpuCost = 16384;//16384;
        int memoryCost = 64;//8;
        int parallelization = 16;//1;
        
        String hashedPassword = SCryptUtil.scrypt(password, cpuCost, memoryCost, parallelization);
        
        System.out.println("Password: " + password);
        System.out.println("Hasshed password: " + hashedPassword);
	}

}
