package za.co.invoketech.store.persistence.internal;

import com.google.inject.persist.Transactional;

import za.co.invoketech.store.domain.model.account.Account;
import za.co.invoketech.store.service.repository.AccountRepository;

@Transactional
class AccountRepositoryImpl extends GenericDaoImpl<Account, Long> implements AccountRepository {

	public AccountRepositoryImpl() {
		super(Account.class);	
	}
}
