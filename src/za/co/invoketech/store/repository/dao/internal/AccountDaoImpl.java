package za.co.invoketech.store.repository.dao.internal;

import za.co.invoketech.store.model.entity.account.Account;
import za.co.invoketech.store.service.dao.AccountDao;

public class AccountDaoImpl extends GenericDaoImpl<Account, Long> implements AccountDao {

	public AccountDaoImpl() {
		super(Account.class);	
	}
	
}
