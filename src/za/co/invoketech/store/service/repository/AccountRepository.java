package za.co.invoketech.store.service.repository;

import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.service.dao.GenericDao;

public interface AccountRepository extends GenericDao<Account, Long> {
	
	Account findByEmail(String email);
}
