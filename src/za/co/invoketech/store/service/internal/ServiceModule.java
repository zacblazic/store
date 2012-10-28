package za.co.invoketech.store.service.internal;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;

import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.account.RoleService;
import za.co.invoketech.store.service.customer.CustomerService;
import za.co.invoketech.store.service.file.FileManager;
import za.co.invoketech.store.service.file.FileUploadService;
import za.co.invoketech.store.service.product.ProductService;

import com.google.inject.AbstractModule;

public class ServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(FileManager.class).to(FileManagerImpl.class);
		bind(FileUploadService.class).to(FileUploadServiceImpl.class);
		bind(AccountService.class).to(AccountServiceImpl.class);
		bind(RoleService.class).to(RoleServiceImpl.class);
		bind(CustomerService.class).to(CustomerServiceImpl.class);
		
		// Shiro bindings
		bind(PasswordService.class).to(DefaultPasswordService.class);
		bind(ProductService.class).to(ProductServiceImpl.class);
	}
}
