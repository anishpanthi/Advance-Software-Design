/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypattern.lab.dao;

import java.util.ArrayList;
import java.util.Collection;
import strategypattern.lab.domain.Account;

/**
 *
 * @author Anish Panthi
 */
public class AccountDAO implements IAccountDAO {

    Collection<Account> accountlist = new ArrayList<>();

    @Override
    public void saveAccount(Account account) {
        accountlist.add(account); // add the new
    }

    @Override
    public void updateAccount(Account account) {
        Account accountexist = loadAccount(account.getAccountNumber());
        if (accountexist != null) {
            accountlist.remove(accountexist); // remove the old
            accountlist.add(account); // add the new
        }

    }

    @Override
    public Account loadAccount(long accountnumber) {
        for (Account account : accountlist) {
            if (account.getAccountNumber() == accountnumber) {
                return account;
            }
        }
        return null;
    }

    @Override
    public Collection<Account> getAccounts() {
        return accountlist;
    }

}
