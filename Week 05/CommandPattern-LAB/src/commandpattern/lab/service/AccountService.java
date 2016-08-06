/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpattern.lab.service;

import commandpattern.lab.dao.AccountDAO;
import commandpattern.lab.dao.IAccountDAO;
import commandpattern.lab.domain.Account;
import commandpattern.lab.domain.Customer;
import java.util.Collection;

/**
 *
 * @author Anish Panthi
 */
public class AccountService implements IAccountService {

    private final IAccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAO();
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
