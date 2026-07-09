package com.example;

import java.awt.Graphics2D;
import com.example.shape.Shape;
import com.example.shape.Triangle;

public class Genome implements Render {
    private Shape[] shapes;

    /**
     * Constructs a Genome with the specified shapes, width, and height.
     *
     * @param shapes the array of shapes to include in the genome
     * @param width  the width of the canvas
     * @param height the height of the canvas
     */
    public Genome(Shape[] shapes, int width, int height) {
        this.shapes = shapes;
    }

    /**
     * Constructs a Genome with the specified width, height, and number of shapes.
     * Each shape is randomly generated.
     * 
     * @param width
     * @param height
     * @param numShapes
     */
    public Genome(int width, int height, int numShapes) {
        Shape[] generated = new Shape[numShapes];
        for (int i = 0; i < numShapes; i++) {
            generated[i] = new Triangle(width, height);
        }
        this.shapes = generated;
    }

    /**
     * Draws all the shapes in the genome on the specified Graphics2D object.
     *
     * @param g2d the Graphics2D object to draw the shapes on
     */
    public void render(Graphics2D g2d) {
        for (Shape shape : shapes) {
            shape.render(g2d);
        }
    }

}
