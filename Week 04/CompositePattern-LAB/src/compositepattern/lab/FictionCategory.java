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
public class FictionCategory implements Catalog {

    private final Book fictionBook;

    public FictionCategory(Book fictionBook) {
        this.fictionBook = fictionBook;
    }

    @Override
    public void print() {
        System.out.println("--- Drama ---");
        System.out.println("Title: " + fictionBook.getTitle());
        System.out.println("ISBN : " + fictionBook.getIsbn());
    }
}
