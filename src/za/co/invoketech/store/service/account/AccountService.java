package za.co.invoketech.store.service.account;

import java.util.List;

import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.RoleNotFoundException;
import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.domain.model.role.Role;

public interface AccountService {
	public Account createAccount(String email, String password, List<Role> roles) throws RoleNotFoundException;
	public Account retrieveAccount(long accountId) throws AccountNotFoundException;
	public void updateAccount(Account account) throws AccountNotFoundException;
	public void removeAccount(Account account) throws AccountNotFoundException;
	public List<Account> retrieveAccountsForRole(Role role);
	public List<Account> retrieveAllAccounts();
	public List<Account> retrieveNonCustomerAccounts();
}
