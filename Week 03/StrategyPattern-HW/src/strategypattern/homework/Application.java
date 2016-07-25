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
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DrawingCanvas dCanvas = new DrawingCanvas();
        
        dCanvas.setIDrawing(new DrawLine());
        dCanvas.drawGeometricShape();
        
        dCanvas.setIDrawing(new DrawCircle());
        dCanvas.drawGeometricShape();
        
        dCanvas.setIDrawing(new DrawRectangle());
        dCanvas.drawGeometricShape();
    }
    
}
