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
public class CeilingFan {

    private FanState currentState;

    public CeilingFan() {
        currentState = new Off();
    }

    public void pullGreen() {
        setCurrentState(currentState.nextState());
        currentState.printState();
    }

    public void pullRed() {
        setCurrentState(currentState.previousState());
        currentState.printState();
    }

    public void setCurrentState(FanState currentState) {
        this.currentState = currentState;
    }
}
