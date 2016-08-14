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
public abstract class AccountState {

    abstract void computePoints(FFAccount account, int newMiles);
}
