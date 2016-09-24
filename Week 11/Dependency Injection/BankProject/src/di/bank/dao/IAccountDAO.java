package di.bank.dao;

import java.util.Collection;

import di.bank.domain.Account;

public interface IAccountDAO {
	void saveAccount(Account account);

	void updateAccount(Account account);

	Account loadAccount(long accountnumber);

	Collection<Account> getAccounts();
}
