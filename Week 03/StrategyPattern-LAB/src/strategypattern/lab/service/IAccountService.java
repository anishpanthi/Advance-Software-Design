/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypattern.lab.service;

import java.util.Collection;
import strategypattern.lab.domain.Account;

/**
 *
 * @author Anish Panthi
 */
public interface IAccountService {

    Account createAccount(long accountNumber, String customerName, String typeName);

    void addInterest(long accountNumber);

    Account getAccount(long accountNumber);

    Collection<Account> getAllAccounts();

    void deposit(long accountNumber, double amount);

    void withdraw(long accountNumber, double amount);

    void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
}
