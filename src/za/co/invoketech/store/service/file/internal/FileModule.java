package za.co.invoketech.store.service.file.internal;

import za.co.invoketech.store.service.file.FileUploadService;

import com.google.inject.AbstractModule;

public class FileModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(FileUploadService.class).to(FileUploadServiceImpl.class);
	}
}
