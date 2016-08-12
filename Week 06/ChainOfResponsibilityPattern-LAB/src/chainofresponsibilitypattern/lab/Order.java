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
public class Order {

    private int orderNumber;
    private double totalAmount;
    private boolean international;

    private Customer customer;

    public Order(int orderNumber, double totalAmount, boolean international, Customer customer) {
        this.orderNumber = orderNumber;
        this.totalAmount = totalAmount;
        this.international = international;
        this.customer = customer;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isInternational() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international = international;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
