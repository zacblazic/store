package za.co.invoketech.store.service.account.internal;

import java.util.List;

import org.apache.shiro.crypto.hash.Sha256Hash;

import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.model.entity.account.Account;
import za.co.invoketech.store.model.entity.role.Role;
import za.co.invoketech.store.service.account.AccountService;
import za.co.invoketech.store.service.dao.AccountDao;
import za.co.invoketech.store.service.dao.RoleDao;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class AccountServiceImpl implements AccountService {
	
	@Inject
	private RoleDao roleDao;
	
	@Inject
	private AccountDao accountDao;
	
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

				account = new Account(email, new Sha256Hash((String)password).toString(), roles);
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

}
