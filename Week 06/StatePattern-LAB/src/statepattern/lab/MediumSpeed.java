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
public class MediumSpeed implements FanState {

    @Override
    public void printState() {
        System.out.println(" medium speed ");
    }

    @Override
    public FanState nextState() {
        return new HighSpeed();
    }

    @Override
    public FanState previousState() {
        return new LowSpeed();
    }
}
