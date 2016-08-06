/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpattern.lab.service;

import commandpattern.lab.domain.Account;
import java.util.Collection;

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
