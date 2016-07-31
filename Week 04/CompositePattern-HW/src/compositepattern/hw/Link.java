/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern.hw;

/**
 *
 * @author Anish Panthi
 */
public class Link implements FileSystem {

    private String name;
    private String link;

    public Link(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    @Override
    public void print() {
        System.out.println("--- link " + name + " to " + getLink());
    }

    @Override
    public int getSizeInBytes() {
        return 0;
    }
}
