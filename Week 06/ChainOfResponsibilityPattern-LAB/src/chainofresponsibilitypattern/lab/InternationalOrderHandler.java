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
public class InternationalOrderHandler extends OrderReceiver {

    @Override
    public void handleOrder(Order order) {
        if (order.isInternational()) {
            System.out.println("International Order");
        } else if (successor != null) {
            successor.handleOrder(order);
        }
    }
}
