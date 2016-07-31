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
public class ProductCatalog implements Catalog {

    private Collection<Catalog> catalogs = new ArrayList<>();

    public void addCatalog(Catalog catalog) {
        catalogs.add(catalog);
    }

    @Override
    public void print() {
        System.out.println("--- Product Catalog ---");
        catalogs.stream().forEach((catalog) -> {
            catalog.print();
        });
    }
}
