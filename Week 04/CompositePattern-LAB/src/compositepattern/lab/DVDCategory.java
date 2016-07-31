/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern.lab;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Anish Panthi
 */
public class DVDCategory implements Catalog {

    private Collection<Catalog> dvdCategories = new ArrayList<>();

    public void add(Catalog dvdCategory) {
        dvdCategories.add(dvdCategory);
    }

    @Override
    public void print() {
        System.out.println("--- DVD Category ---");

        dvdCategories.stream().forEach((catalog) -> {
            catalog.print();
        });
    }
}
