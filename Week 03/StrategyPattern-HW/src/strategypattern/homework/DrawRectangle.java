/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypattern.homework;

/**
 *
 * @author Anish Panthi
 */
public class DrawRectangle implements IDrawing {

    @Override
    public void draw() {
        System.out.println("Rectangle Drawn...");
    }

}
