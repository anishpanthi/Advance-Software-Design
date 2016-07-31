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
public class ComputerBookCategory implements Catalog {

    private Book computerBook;

    public ComputerBookCategory(Book computerBook) {
        this.computerBook = computerBook;
    }

    @Override
    public void print() {
        System.out.println("--- Drama ---");
        System.out.println("Title: " + computerBook.getTitle());
        System.out.println("ISBN : " + computerBook.getIsbn());
    }
}
