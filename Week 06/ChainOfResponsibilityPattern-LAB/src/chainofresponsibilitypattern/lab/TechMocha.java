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
public class TechMocha {
    
    public static void main(String[] args) {
        int x=0;
        int y=0;
        for (int i = 0; i < 5; i++) {
            
            if((++x>2) && (++y>2)){
                x++;
            }
        }
        System.out.println(x+" "+y);
    }
    
}
