package za.co.invoketech.store.application.util.library;

public class SystemLibraryLoader implements LibraryLoader {

	 public boolean load(String name, boolean verify) {
	        boolean loaded;

	        try {
	            System.loadLibrary(name);
	            loaded = true;
	        } catch (Throwable e) {
	            loaded = false;
	        }

	        return loaded;
	    }
}
