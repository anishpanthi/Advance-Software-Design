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
 */
public interface IStockBroker {
    
    void update(Map<String, Double> stockList);
    
}
