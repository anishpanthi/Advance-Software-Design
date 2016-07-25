/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypattern.lab.main;

import java.util.Collection;
import strategypattern.lab.domain.Account;
import strategypattern.lab.domain.AccountEntry;
import strategypattern.lab.domain.Customer;
import strategypattern.lab.service.AccountService;
import strategypattern.lab.service.IAccountService;

/**
 *
 * @author Anish Panthi
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IAccountService accountService = new AccountService();
        // create 2 accounts;
        accountService.createAccount(1263862, "Frank Brown", "saving");
        accountService.createAccount(4253892, "John Doe", "checking");
        //use account 1;
        accountService.deposit(1263862, 240);
        accountService.deposit(1263862, 529);
        accountService.withdraw(1263862, 230);
        accountService.addInterest(1263862);
        //use account 2;
        accountService.deposit(4253892, 12450);
        accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
        accountService.addInterest(4253892);
        // show balances

        Collection<Account> accountlist = accountService.getAllAccounts();
        Customer customer = null;
        for (Account account : accountlist) {
            customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountNumber());
            System.out.println("Account Type: " + account.getAccountType());
            System.out.println("Account Holder: " + customer.getName());
            System.out.println("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");
            account.getEntryList().stream().forEach((entry) -> {
                System.out.printf("%30s%30s%20.2f\n", entry.getDate()
                        .toString(), entry.getDescription(), entry.getAmount());
            });
            System.out.println("----------------------------------------"
                    + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n", "", "Current Balance:",
                    account.getBalance());
            System.out.printf("%30s%30s%20.2f\n\n", "", "Interest amount:",
                    account.getInterest());
        }
    }

}
