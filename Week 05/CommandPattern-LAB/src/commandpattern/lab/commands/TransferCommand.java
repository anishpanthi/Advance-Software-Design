/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpattern.lab.commands;

import commandpattern.lab.service.IAccountService;

/**
 *
 * @author Anish Panthi
 */
public class TransferCommand implements Command {

    private final long fromAccountNumber;
    private final long toAccountNumber;
    private final double amount;
    private final String description;
    private final IAccountService accountService;

    public TransferCommand(long fromAccountNumber, long toAccountNumber, double amount, String description, IAccountService accountService) {
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.description = description;
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        accountService.transferFunds(fromAccountNumber, toAccountNumber, amount, description);
    }

    @Override
    public void undo() {
        accountService.transferFunds(toAccountNumber, fromAccountNumber, amount, description);
    }

    @Override
    public void redo() {
        execute();
    }
}
