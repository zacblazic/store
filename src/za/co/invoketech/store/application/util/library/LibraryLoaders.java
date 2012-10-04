package za.co.invoketech.store.application.util.library;

public class LibraryLoaders {
	
	public static LibraryLoader loader() {
        String vmSpec = System.getProperty("java.vm.specification.name");
        return vmSpec.startsWith("Java") ? new JarLibraryLoader() : new SystemLibraryLoader();
    }
}
