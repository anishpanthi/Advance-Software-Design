/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypattern.lab.domain;

/**
 *
 * @author Anish Panthi
 */
public class SavingAccount implements AccountType {

    @Override
    public double calculateInterest(double balance) {
        double interest;
        if (balance < 1000) {
            interest = balance * 0.01;
        } else if (balance > 1000 && balance < 5000) {
            interest = balance * 0.02;
        } else {
            interest = balance * 0.04;
        }
        return interest;
    }

    @Override
    public String toString() {
        return "Saving Account";
    }
}
