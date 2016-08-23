package proxypattern.lab.dao;

import java.util.Collection;
import proxypattern.lab.domain.Account;

/**
 *
 * @author Anish Panthi
 */
public interface IAccountDAO {

    void saveAccount(Account account);

    void updateAccount(Account account);

    Account loadAccount(long accountnumber);

    Collection<Account> getAccounts();
}
