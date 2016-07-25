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
public class CheckingAccount implements AccountType {

    @Override
    public double calculateInterest(double balance) {
        return (balance < 1000) ? balance * 0.015 : balance * 0.025;
    }

    @Override
    public String toString() {
        return "Checking Account";
    }
}
