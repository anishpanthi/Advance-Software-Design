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
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        Book book1 = new Book("1000A89", "Palpasa Cafe");
        Book book2 = new Book("43432P0", "Learn Java");

        FictionCategory fiction = new FictionCategory(book1);
        ComputerBookCategory computerBook = new ComputerBookCategory(book2);

        BookCategory bookCategory = new BookCategory();
        bookCategory.add(fiction);
        bookCategory.add(computerBook);

        DVD dvd1 = new DVD("Avengers");
        DVD dvd2 = new DVD("King's speech");

        Drama drama = new Drama(dvd2);
        Action action = new Action(dvd1);

        DVDCategory dvdCategory = new DVDCategory();
        dvdCategory.add(drama);
        dvdCategory.add(action);

        catalog.addCatalog(dvdCategory);
        catalog.addCatalog(bookCategory);

        catalog.print();
    }
}
