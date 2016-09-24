package di.bank.dao;

import java.util.Collection;

import di.bank.domain.Account;

public class TestAccountDAO implements IAccountDAO {

	public void saveAccount(Account account) {
		System.out.println("saveAccount() called...");
	}

	public void updateAccount(Account account) {
		System.out.println("updateAccount() called...");
	}

	public Account loadAccount(long accountnumber) {
		System.out.println("loadAccount() called...");
		return null;
	}

	public Collection<Account> getAccounts() {
		System.out.println("getAccounts() called...");
		return null;
	}
}
