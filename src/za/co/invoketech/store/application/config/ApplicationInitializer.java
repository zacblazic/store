package za.co.invoketech.store.application.config;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

public class ApplicationInitializer {
	
	@Inject
	public ApplicationInitializer(PersistService service) {
		service.start();
	}
}
