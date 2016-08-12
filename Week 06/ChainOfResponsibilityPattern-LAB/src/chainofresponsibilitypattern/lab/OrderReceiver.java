/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresponsibilitypattern.lab;

/**
 *
 * @author Anish Panthi
 */
public abstract class OrderReceiver {

    protected OrderReceiver successor;
    protected Order order;

    public void setSuccessor(OrderReceiver successor) {
        this.successor = successor;
    }

    abstract public void handleOrder(Order request);
}
