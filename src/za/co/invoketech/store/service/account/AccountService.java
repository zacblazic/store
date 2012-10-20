package za.co.invoketech.store.service.account;

import java.util.List;

import za.co.invoketech.store.application.exception.AccountNotFoundException;
import za.co.invoketech.store.application.exception.NonExistentRoleException;
import za.co.invoketech.store.model.entity.account.Account;
import za.co.invoketech.store.model.entity.role.Role;

public interface AccountService {
	public Account createAccount(String email, String password, List<Role> roles) throws NonExistentRoleException;
	public Account retrieveAccount(long accountId) throws AccountNotFoundException;
	public void updateAccount(Account account) throws AccountNotFoundException;
	public void removeAccount(Account account) throws AccountNotFoundException;
}
