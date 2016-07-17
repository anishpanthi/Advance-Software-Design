/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern.homework;

/**
 *
 * @author Anish Panthi
 */
public class ObserverPatternMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        
        IStockBroker buyer = new StockBuyer();
        IStockBroker viewer = new StockViewer();
        
        stockMarket.addStockBroker(buyer);
        stockMarket.addStockBroker(viewer);
        
        stockMarket.addStock("ORC",12.23);
        stockMarket.addStock("MSC",45.78);
        
        stockMarket.update("ORC", 12.34);
        stockMarket.update("MSC", 44.68);
    }
}
