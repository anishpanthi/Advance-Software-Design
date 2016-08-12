/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresponsibilitypattern.lab;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anish Panthi
 */
public class MostFavoredCustomerOrderHandler extends OrderReceiver {

    private List<MostValuedCustomer> customers = new ArrayList<MostValuedCustomer>() {
        {
            add(new MostValuedCustomer("Yogen"));
            add(new MostValuedCustomer("Rita"));
        }
    };

    @Override
    public void handleOrder(Order request) {
        Customer orderingCustomer = request.getCustomer();
        for (MostValuedCustomer customer : customers) {
            if (customer.getName().equals(orderingCustomer.getName())) {
                System.out.println("Most Valued Customer Chance.");
                return;
            }
        }
        if (successor != null) {
            successor.handleOrder(request);
        }
    }
}
