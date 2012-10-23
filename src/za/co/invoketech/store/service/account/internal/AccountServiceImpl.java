package za.co.invoketech.store.service.account.internal;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;

import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.role.Role;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.repository.AccountRepository;
import za.co.invoketech.store.service.repository.RoleRepository;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class AccountServiceImpl implements AccountService {
	
	@Inject
	private RoleRepository roleDao;
	
	@Inject
	private AccountRepository accountDao;
	
	@Override
	public Account createAccount(String email, String password, List<Role> roles) throws RoleNotFoundException {
		Account account;		
		
		if (roles != null && roles.size() != 0)
		{
			// Find if roles exist
			try 
			{
				for (Role role : roles)
				roleDao.findByAttribute("roleName", role.getRoleName());
				
				PasswordService psvc = new DefaultPasswordService();
				
				account = new Account(email, psvc.encryptPassword(password), roles);
				accountDao.persist(account);
			} 
			catch (Exception e) 
			{
				throw new RoleNotFoundException();
			}
			
		}
		else throw new RoleNotFoundException("No role assigned");
		
		return account;
	}

	@Override
	public Account retrieveAccount(long accountId) throws AccountNotFoundException {
		Account account = accountDao.findById(accountId);
		if (account == null)
		{
			throw new AccountNotFoundException();
		}
		
		return account;
	}

	@Override
	public void updateAccount(Account account) throws AccountNotFoundException {
		if (account == null || account.getId() == 0)
		{
			throw new AccountNotFoundException("Cannot update account with no id");
		}
		
		accountDao.merge(account);
	}

	@Override
	public void removeAccount(Account account) throws AccountNotFoundException {
		if (account == null || account.getId() == 0)
		{
			throw new AccountNotFoundException("Cannot remove account with no id");
		}
		
		accountDao.remove(account);
	}

	@Override
	public List<Account> retrieveAccountsForRole(Role role) {
		List<Account> accounts = accountDao.findAll();
		List<Account> returnAccounts = new ArrayList<Account>();
		boolean remove;		
		for (Account account : accounts) {
			remove = true;
			List<Role> roles = account.getRoles();
			for (Role roleItem : roles) {
				if (roleItem.equals(role)) remove = false;				
			}
			if (!remove) returnAccounts.add(account);
		}		
		return returnAccounts;
	}

	@Override
	public List<Account> retrieveAllAccounts() {
		List<Account> accounts = accountDao.findAll();
		return accounts;
	}

	@Override
	public List<Account> retrieveNonCustomerAccounts() {
		List<Account> accounts = accountDao.findAll();
		List<Account> returnAccounts = new ArrayList<Account>();
		for (Account account : accounts) {
			if (account.getCustomer() == null) returnAccounts.add(account);
		}
		return returnAccounts;
	}

}
