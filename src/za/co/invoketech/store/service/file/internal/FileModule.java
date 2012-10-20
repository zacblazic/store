package za.co.invoketech.store.service.file.internal;

import za.co.invoketech.store.service.file.FileManager;
import za.co.invoketech.store.service.file.FileUploadService;

import com.google.inject.AbstractModule;

public class FileModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(FileManager.class).to(FileManagerImpl.class);
		bind(FileUploadService.class).to(FileUploadServiceImpl.class);
	}
}
