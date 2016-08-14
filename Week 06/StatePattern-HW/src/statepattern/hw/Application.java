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
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FFAccount ffaccount = new FFAccount("213425");
        ffaccount.addFlight(13000);
        System.out.println("Account Number =" + ffaccount.getAccountNumber());
        System.out.println("Account type =" + ffaccount.getAccountState());
        System.out.println("miles =" + ffaccount.getNumberOfMiles());

        ffaccount.addFlight(99000);
        System.out.println("Account Number =" + ffaccount.getAccountNumber());
        System.out.println("Account type =" + ffaccount.getAccountState());
        System.out.println("miles =" + ffaccount.getNumberOfMiles());
    }

}
