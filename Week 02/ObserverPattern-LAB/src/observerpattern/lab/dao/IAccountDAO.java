package observerpattern.lab.dao;

import java.util.Collection;
import observerpattern.lab.domain.Account;
import observerpattern.lab.observer.IObserver;

public interface IAccountDAO {

    void saveAccount(Account account);

    void updateAccount(Account account);

    Account loadAccount(long accountnumber);

    Collection<Account> getAccounts();
    
    void register(IObserver observer);
    
    void unregister(IObserver observer);
    
    void notifyObservers();
}
