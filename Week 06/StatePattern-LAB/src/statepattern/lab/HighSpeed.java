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
public class HighSpeed implements FanState {

    @Override
    public FanState nextState() {
        return new Off();
    }

    @Override
    public FanState previousState() {
        return new MediumSpeed();
    }

    @Override
    public void printState() {
        System.out.println(" high speed ");
    }
}
