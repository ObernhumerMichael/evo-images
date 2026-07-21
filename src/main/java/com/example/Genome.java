package com.example;

import java.awt.Graphics2D;
import com.example.shape.Triangle;

public class Genome implements Renderable {
    private Triangle[] triangles;

    /**
     * Constructs a Genome with the specified shapes, width, and height.
     *
     * @param triangles the array of triangles to include in the genome
     * @param width     the width of the canvas
     * @param height    the height of the canvas
     */
    public Genome(Triangle[] triangles, int width, int height) {
        this.triangles = triangles;
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
        Triangle[] generated = new Triangle[numShapes];
        for (int i = 0; i < numShapes; i++) {
            generated[i] = new Triangle(width, height);
        }
        this.triangles = generated;
    }

    /**
     * Draws all the shapes in the genome on the specified Graphics2D object.
     *
     * @param g2d the Graphics2D object to draw the shapes on
     */
    public void render(Graphics2D g2d) {
        for (Triangle triangle : triangles) {
            triangle.render(g2d);
        }
    }

}
