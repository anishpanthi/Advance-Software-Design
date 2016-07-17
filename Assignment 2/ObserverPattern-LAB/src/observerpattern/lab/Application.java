/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern.lab;

import java.util.Collection;
import observerpattern.lab.domain.Account;
import observerpattern.lab.domain.AccountEntry;
import observerpattern.lab.domain.Customer;
import observerpattern.lab.service.AccountService;
import observerpattern.lab.service.IAccountService;

/**
 *
 * @author Anish Panthi
 */
public class Application {

    public static void main(String[] args) {
        IAccountService accountService = new AccountService();
        // create 2 accounts;
        accountService.createAccount(1263862, "Frank Brown");
        accountService.createAccount(4253892, "John Doe");
        //use account 1;
        accountService.deposit(1263862, 240);
        accountService.deposit(1263862, 529);
        accountService.withdraw(1263862, 230);
        //use account 2;
        accountService.deposit(4253892, 12450);
        accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
        // show balances

        Collection<Account> accountlist = accountService.getAllAccounts();
        Customer customer = null;
        for (Account account : accountlist) {
            customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountnumber());
            System.out.println("Account Holder: " + customer.getName());
            System.out.println("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");
            for (AccountEntry entry : account.getEntryList()) {
                System.out.printf("%30s%30s%20.2f\n", entry.getDate()
                        .toString(), entry.getDescription(), entry.getAmount());
            }
            System.out.println("----------------------------------------"
                    + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
                    account.getBalance());
        }
    }

}
