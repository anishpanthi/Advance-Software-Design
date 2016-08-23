package proxypattern.lab.service;

import java.util.Collection;
import java.lang.reflect.Proxy;
import proxypattern.lab.dao.AccountDAO;
import proxypattern.lab.dao.IAccountDAO;
import proxypattern.lab.domain.Account;
import proxypattern.lab.domain.Customer;
import proxypattern.lab.proxy.Logger;
import proxypattern.lab.proxy.Timer;

/**
 *
 * @author Anish Panthi
 */
public class AccountService implements IAccountService {

    private IAccountDAO accountDAO;

    public AccountService() {

        IAccountDAO myAccountDAO = new AccountDAO();
        ClassLoader classLoader = IAccountDAO.class.getClassLoader();
        IAccountDAO myLoggeraccountDAO = (IAccountDAO) Proxy.newProxyInstance(classLoader, new Class[]{IAccountDAO.class},
                new Logger(myAccountDAO));

        accountDAO = (IAccountDAO) Proxy.newProxyInstance(classLoader, new Class[]{IAccountDAO.class},
                new Timer(myLoggeraccountDAO));

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
