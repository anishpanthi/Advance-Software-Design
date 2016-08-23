/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxypattern.lab;

import proxypattern.lab.service.AccountService;
import proxypattern.lab.service.IAccountService;
import java.lang.reflect.Proxy;
import java.util.Collection;
import proxypattern.lab.domain.Account;
import proxypattern.lab.domain.AccountEntry;
import proxypattern.lab.domain.Customer;
import proxypattern.lab.proxy.Timer;

/**
 *
 * @author Anish Panthi
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IAccountService myAccountService = new AccountService();
        ClassLoader classLoader = IAccountService.class.getClassLoader();
        IAccountService accountService = (IAccountService) Proxy.newProxyInstance(classLoader, new Class[]{IAccountService.class}, new Timer(myAccountService));

        // create 2 accounts;
        accountService.createAccount(1263862, "Hilary Clinton");
        accountService.createAccount(4253892, "Donald Trump");
        // use account 1;
        accountService.deposit(1263862, 240);
        accountService.deposit(1263862, 529);
        accountService.withdraw(1263862, 230);
        // use account 2;
        accountService.deposit(4253892, 12450);
        accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
        // show balances

        Collection<Account> accountlist = accountService.getAllAccounts();
        Customer customer = null;
        for (Account account : accountlist) {
            customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountnumber());
            System.out.println("Account Holder: " + customer.getName());
            System.out.println(
                    "-Date-------------------------" + "-Description------------------" + "-Amount-------------");
            for (AccountEntry entry : account.getEntryList()) {
                System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
                        entry.getAmount());
            }
            System.out.println("----------------------------------------" + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
        }

    }

}
