package za.co.invoketech.store.service.account.internal;

import za.co.invoketech.store.service.account.AccountService;

import com.google.inject.AbstractModule;

public class AccountRoleModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(AccountService.class).to(AccountServiceImpl.class);
		
	}

}
