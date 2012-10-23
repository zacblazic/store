package za.co.invoketech.store.quick;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.persistence.internal.PersistenceModule;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.account.RoleService;
import za.co.invoketech.store.service.account.internal.AccountRoleModule;
import za.co.invoketech.store.service.repository.AccountRepository;
import za.co.invoketech.store.service.repository.CustomerRepository;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class QuickTest {
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	private static AccountService accountService;
	private static RoleService roleService;
	private static CustomerRepository customerDao;
	private static AccountRepository accountDao;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		injector = Guice.createInjector(new AccountRoleModule(), new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		accountService = injector.getInstance(AccountService.class);
		roleService = injector.getInstance(RoleService.class);
		customerDao = injector.getInstance(CustomerRepository.class);
		accountDao = injector.getInstance(AccountRepository.class);
	}

	@Test
	public void test() {
		List<Account> accounts2 = accountService.retrieveNonCustomerAccounts();
		for (Account account2 : accounts2) {
			System.out.println(account2.getEmail());
		}
	}

}
