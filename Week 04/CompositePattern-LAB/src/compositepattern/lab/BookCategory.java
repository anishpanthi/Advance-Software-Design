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
public class BookCategory implements Catalog {

    private Collection<Catalog> bookCategories = new ArrayList<>();

    public void add(Catalog bookCatalog) {
        bookCategories.add(bookCatalog);
    }

    @Override
    public void print() {
        System.out.println("--- Book Category ---");

        bookCategories.stream().forEach((bookCategory) -> {
            bookCategory.print();
        });
    }
}
