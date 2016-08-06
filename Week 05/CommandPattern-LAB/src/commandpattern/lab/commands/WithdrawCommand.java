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
public class WithdrawCommand implements Command {

    private final IAccountService accountService;
    private final long accNo;
    private final double withdrawAmount;

    public WithdrawCommand(IAccountService accountService, long accNo, double withdrawAmount) {
        this.accountService = accountService;
        this.accNo = accNo;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void execute() {
        accountService.withdraw(accNo, withdrawAmount);
    }

    @Override
    public void undo() {
        accountService.deposit(accNo, withdrawAmount);
    }

    @Override
    public void redo() {
        execute();
    }
}
