/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern.hw;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Anish Panthi
 */
public class Drive implements FileSystem {

    protected String name;

    protected Collection<FileSystem> fileSystems = new ArrayList<>();

    public Drive(String name) {
        this.name = name;
    }

    public void addFileSystem(FileSystem fileSystem) {
        fileSystems.add(fileSystem);
    }

    @Override
    public int getSizeInBytes() {
        int sizeInBytes = 0;
        sizeInBytes = fileSystems.stream().map((fileSystem) -> fileSystem.getSizeInBytes()).reduce(sizeInBytes, Integer::sum);
        return sizeInBytes;
    }

    @Override
    public void print() {
        System.out.println("- drive " + name);
        fileSystems.stream().forEach((fileSystem) -> {
            fileSystem.print();
        });
    }
}
