package proxypattern.lab.dao;

import java.util.ArrayList;
import java.util.Collection;
import proxypattern.lab.domain.Account;

/**
 *
 * @author Anish Panthi
 */
public class AccountDAO implements IAccountDAO {

    Collection<Account> accountlist = new ArrayList<Account>();

    public Account loadAccount(long accountnumber) {
        for (Account account : accountlist) {
            if (account.getAccountnumber() == accountnumber) {
                return account;
            }
        }
        return null;
    }

    public Collection<Account> getAccounts() {
        return accountlist;
    }

    @Override
    public void saveAccount(Account account) {
        accountlist.add(account); // add the new
    }

    @Override
    public void updateAccount(Account account) {
        Account accountexist = loadAccount(account.getAccountnumber());
        if (accountexist != null) {
            accountlist.remove(accountexist); // remove the old
            accountlist.add(account); // add the new
        }
    }

}
