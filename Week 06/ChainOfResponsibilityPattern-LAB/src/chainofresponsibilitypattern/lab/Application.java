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
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrderReceiver mostValued = new MostFavoredCustomerOrderHandler();
        OrderReceiver largeOrder = new LargeOrderHandler();
        OrderReceiver international = new InternationalOrderHandler();
        OrderReceiver domestic = new DomesticOrderHandler();

        mostValued.setSuccessor(largeOrder);
        largeOrder.setSuccessor(international);
        international.setSuccessor(domestic);

        Customer customer1 = new Customer("Yogen");
        Customer customer2 = new Customer("Robert");

        Order order1 = new Order(1001, 12300, false, customer1);
        Order order2 = new Order(1002, 1300, true, customer2);

        mostValued.handleOrder(order1);
        mostValued.handleOrder(order2);
    }

}
