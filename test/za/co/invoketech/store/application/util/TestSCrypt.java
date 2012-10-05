package za.co.invoketech.store.application.util;

public class TestSCrypt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	String password = "mushki12";
	int cpuCost = 16384;//16384;
        int memoryCost = 64;//8;
        int parallelization = 4;//1;
        
        String hashedPassword1 = SCryptUtil.scrypt(password, cpuCost, memoryCost, parallelization);
        String hashedPassword2 = SCryptUtil.scrypt(password, cpuCost, memoryCost, parallelization);
        
        System.out.println("Password: " + password);
        System.out.println("Hasshed password 1: " + hashedPassword1);
        System.out.println("Hasshed password 2: " + hashedPassword2);
	}

}
