/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern.homework;

import java.util.Map;

/**
 *
 * @author Anish Panthi
 *
 * Observer Class
 */
public class StockBuyer implements IStockBroker {

    @Override
    public void update(Map<String, Double> stockList) {
        System.out.println("StockBuyer: StockList has been changed.");
        stockList.entrySet().stream().forEach((entry) -> {
            String key = (String) entry.getKey();
            Double value = entry.getValue();
            System.out.println("StockBuyer " + key + " - $" + value);
        });
    }
}
