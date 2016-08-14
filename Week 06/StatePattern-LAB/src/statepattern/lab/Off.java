/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statepattern.lab;

/**
 *
 * @author Anish Panthi
 */
public class Off implements FanState {

    @Override
    public void printState() {
        System.out.println(" fan is off ");
    }

    @Override
    public FanState nextState() {
        return new LowSpeed();
    }

    @Override
    public FanState previousState() {
        return new HighSpeed();
    }
}
