package observerpattern.lab.service;

import java.util.Collection;
import observerpattern.lab.dao.AccountDAO;
import observerpattern.lab.dao.IAccountDAO;
import observerpattern.lab.domain.Account;
import observerpattern.lab.domain.Customer;
import observerpattern.lab.observer.EmailSender;
import observerpattern.lab.observer.Logger;
import observerpattern.lab.observer.SMSSender;

public class AccountService implements IAccountService {

    private final IAccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAO();
        new Logger(accountDAO);
        new EmailSender(accountDAO);
        new SMSSender(accountDAO);
    }

    @Override
    public Account createAccount(long accountNumber, String customerName) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        accountDAO.saveAccount(account);
        return account;
    }

    @Override
    public void deposit(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
    }

    @Override
    public Account getAccount(long accountNumber) {
        Account account = accountDAO.loadAccount(accountNumber);
        return account;
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    @Override
    public void withdraw(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
    }

    @Override
    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
    }
}
