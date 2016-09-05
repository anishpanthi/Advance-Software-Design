package factorypattern.dao;

import factorypattern.domain.Account;

import java.util.Collection;

public interface IAccountDAO {

    void saveAccount(Account account);

    void updateAccount(Account account);

    Account loadAccount(long accountnumber);

    Collection<Account> getAccounts();
}
