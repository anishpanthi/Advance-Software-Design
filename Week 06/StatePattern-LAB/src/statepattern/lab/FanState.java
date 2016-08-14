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
public interface FanState {

    void printState();

    FanState nextState();

    FanState previousState();
}
