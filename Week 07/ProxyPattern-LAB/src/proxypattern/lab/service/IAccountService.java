package proxypattern.lab.service;

import java.util.Collection;
import proxypattern.lab.domain.Account;

/**
 *
 * @author Anish Panthi
 */
public interface IAccountService {

    Account createAccount(long accountNumber, String customerName);

    Account getAccount(long accountNumber);

    Collection<Account> getAllAccounts();

    void deposit(long accountNumber, double amount);

    void withdraw(long accountNumber, double amount);

    void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
}
