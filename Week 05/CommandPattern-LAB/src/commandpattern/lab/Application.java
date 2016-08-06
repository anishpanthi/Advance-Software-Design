/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpattern.lab;

import commandpattern.lab.commands.Command;
import commandpattern.lab.commands.DepositCommand;
import commandpattern.lab.commands.TransferCommand;
import commandpattern.lab.commands.WithdrawCommand;
import commandpattern.lab.domain.Account;
import commandpattern.lab.domain.Customer;
import commandpattern.lab.service.AccountService;
import commandpattern.lab.service.IAccountService;
import java.util.Collection;

/**
 *
 * @author Anish Panthi
 */
public class Application {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();

        IAccountService accountService = new AccountService();
        // create 2 accounts;
        accountService.createAccount(1263862, "Frank Brown");
        accountService.createAccount(4253892, "John Doe");

        //use account 1;
        Command depositCommand1 = new DepositCommand(accountService, 1263862, 240);
        Command depositCommand2 = new DepositCommand(accountService, 1263862, 529);

        invoker.execute(depositCommand1);
        invoker.execute(depositCommand2);

        Command withdrawCommand = new WithdrawCommand(accountService, 1263862, 230);
        invoker.execute(withdrawCommand);
        invoker.undo();
        invoker.redo();

        //use account 2;
        Command depositCommand = new DepositCommand(accountService, 4253892, 12450);
        invoker.execute(depositCommand);

        Command transferCommand = new TransferCommand(4253892, 1263862, 100, "payment of invoice 10232", accountService);
        invoker.execute(transferCommand);
        invoker.undo();

        // show balances
        Collection<Account> accountlist = accountService.getAllAccounts();
        Customer customer = null;
        for (Account account : accountlist) {
            customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountNumber());
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
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
                    account.getBalance());
        }
    }
}
