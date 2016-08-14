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
public class Platinum extends AccountState {

    @Override
    void computePoints(FFAccount account, int newMiles) {

        int numberOfFlights = account.getNumberOfFlights();
        account.setNumberOfFlights(2 * numberOfFlights);
        int numberOfMiles = 3 * newMiles + account.getNumberOfMiles();//
        account.setNumberOfMiles(numberOfMiles);
    }

    @Override
    public String toString() {
        return "Platinum";
    }
}
