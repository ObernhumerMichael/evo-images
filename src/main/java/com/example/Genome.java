package com.example;

import java.awt.Graphics2D;
import java.util.Random;

public class Genome implements Gene {
    private static final double MUTATION_RATE = 0.03; // 3% mutation rate
    private static final Random random = new Random();
    private Shape[] shapes;
    private final int width;
    private final int height;

    /**
     * Constructs a Genome with the specified shapes, width, and height.
     *
     * @param shapes the array of shapes to include in the genome
     * @param width  the width of the canvas
     * @param height the height of the canvas
     */
    public Genome(Shape[] shapes, int width, int height) {
        this.shapes = shapes;
        this.width = width;
        this.height = height;
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
        Shape[] shapes = new Shape[numShapes];
        for (int i = 0; i < numShapes; i++) {
            shapes[i] = new Triangle(width, height);
        }
        this.shapes = shapes;
        this.width = width;
        this.height = height;
    }

    @Override
    public void mutate() {
        for (Shape shape : shapes) {
            if (random.nextDouble() < MUTATION_RATE) {
                shape.mutate();
            }
        }
    }

    /**
     * Draws all the shapes in the genome on the specified Graphics2D object.
     *
     * @param g2d the Graphics2D object to draw the shapes on
     */
    public void draw(Graphics2D g2d) {
        for (Shape shape : shapes) {
            shape.draw(g2d);
        }
    }

}
