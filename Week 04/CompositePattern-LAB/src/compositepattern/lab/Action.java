/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern.lab;

/**
 *
 * @author Anish Panthi
 */
public class Action implements Catalog {

    private final DVD actionDVD;

    public Action(DVD actionDVD) {
        this.actionDVD = actionDVD;
    }

    @Override
    public void print() {
        System.out.println("--- Drama ---");
        System.out.println("--- " + actionDVD.getTitle());
    }
}
