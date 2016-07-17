/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern.homework;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anish Panthi
 */
public class StockMarket extends AMarket {

    private final List<IStockBroker> stockBrokers = new ArrayList<>();

    public void addStockBroker(IStockBroker stockBroker) {
        stockBrokers.add(stockBroker);
    }

    public void addStock(String stockSymbol, Double price) {
        stockList.put(stockSymbol, price);
    }

    public void update(String stockSymbol, Double price) {
        stockList.put(stockSymbol, price);
        notifyStockBroker();
    }

    public void notifyStockBroker() {
        stockBrokers.stream().forEach((broker) -> {
            broker.update(stockList);
        });
    }

}
