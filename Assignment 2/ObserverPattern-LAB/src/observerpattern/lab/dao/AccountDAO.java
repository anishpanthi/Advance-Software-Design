package observerpattern.lab.dao;

import java.util.*;
import observerpattern.lab.domain.Account;
import observerpattern.lab.observer.IObserver;

public class AccountDAO implements IAccountDAO {

    private final Collection<Account> accountlist = new ArrayList<>();

    private final List<IObserver> observers = new ArrayList<>();

    @Override
    public void saveAccount(Account account) {
        accountlist.add(account); // add the new
        notifyObservers();
    }

    @Override
    public void updateAccount(Account account) {
        Account accountexist = loadAccount(account.getAccountnumber());
        if (accountexist != null) {
            accountlist.remove(accountexist); // remove the old
            accountlist.add(account); // add the new
        }
        notifyObservers();
    }

    @Override
    public Account loadAccount(long accountnumber) {
        for (Account account : accountlist) {
            if (account.getAccountnumber() == accountnumber) {
                return account;
            }
        }
        return null;
    }

    @Override
    public Collection<Account> getAccounts() {
        return accountlist;
    }

    @Override
    public void register(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(IObserver observer) {
        int observerIndex = observers.indexOf(observer);

        observers.remove(observerIndex);
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach((o) -> {
            o.provideService();
        });
    }
}
