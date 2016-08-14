/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statepattern.hw;

/**
 *
 * @author Anish Panthi
 */
public class FFAccount {

    private String accountNumber;
    private int numberOfMiles;
    private int numberOfFlights;

    private AccountState accountState;

    public FFAccount(String aNumber) {
        accountNumber = aNumber;
        setAccountState(new Silver());
    }

    public void addFlight(int newMiles) {
        accountState.computePoints(this, newMiles);
    }

    public int getNumberOfMiles() {
        return numberOfMiles;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setNumberOfMiles(int numberOfMiles) {
        this.numberOfMiles = numberOfMiles;
    }

    public void setNumberOfFlights(int numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }

    public AccountState getAccountState() {
        return accountState;
    }
}
