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
public class DepositCommand implements Command {

    private final IAccountService accountService;
    private final long accNo;
    private final double depositAmount;

    public DepositCommand(IAccountService accountService, long accNo, double depositAmount) {
        this.accountService = accountService;
        this.accNo = accNo;
        this.depositAmount = depositAmount;
    }

    @Override
    public void execute() {
        accountService.deposit(accNo, depositAmount);
    }

    @Override
    public void undo() {
        accountService.withdraw(accNo, depositAmount);
    }

    @Override
    public void redo() {
        execute();
    }
}
