/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern.lab;

/**
 *
 * @author Anish Panthi
 */
public class Drama implements Catalog {

    private DVD dramaDVD;

    public Drama(DVD dramaDVD) {
        this.dramaDVD = dramaDVD;
    }

    @Override
    public void print() {
        System.out.println("--- Drama ---");
        System.out.println("---- " + dramaDVD.getTitle());
    }
}
