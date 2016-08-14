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
public class Silver extends AccountState {

    @Override
    void computePoints(FFAccount account, int newMiles) {

        int numberOfFlights = account.getNumberOfFlights();
        account.setNumberOfFlights(++numberOfFlights);
        int numberOfMiles = newMiles + account.getNumberOfMiles();//
        account.setNumberOfMiles(numberOfMiles);

        if ((numberOfMiles > 75000) || (numberOfFlights > 75)) {
            account.setAccountState(new Gold());// = "gold";
        }
    }

    @Override
    public String toString() {
        return "Silver";
    }
}
