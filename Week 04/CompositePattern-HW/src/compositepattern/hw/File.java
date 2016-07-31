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
public class File implements FileSystem {

    private String name;
    private int sizeInBytes;

    public File(String name, int sizeInBytes) {
        this.name = name;
        this.sizeInBytes = sizeInBytes;
    }

    @Override
    public int getSizeInBytes() {
        return sizeInBytes;
    }

    @Override
    public void print() {
        System.out.println("--- file " + name + " size=" + getSizeInBytes() + " bytes");
    }
}
