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
public class LargeOrderHandler extends OrderReceiver {

    @Override
    public void handleOrder(Order request) {
        if (request.getTotalAmount() > 30000) {
            System.out.println("Large order handle");
        } else if (successor != null) {
            successor.handleOrder(request);
        }
    }
}
