package com.example;

import java.awt.Graphics2D;
import java.util.Random;

public class Triangle implements Shape {
    private static final Random random = new Random();
    private ColorGene color;
    /** An array of three vertices that define the triangle */
    private Vertex[] vertices;
    private final int width;
    private final int height;

    /**
     * Constructs a Triangle with the specified RGB color, opacity, and three
     * vertices.
     * 
     * @param rgbColor must be an array of three integers representing the red,
     *                 green, and blue components of the color
     * @param opacity  must be an integer between 0 and 255 representing the opacity
     *                 of the shape
     * @param vertex1  the first vertex of the triangle
     * @param vertex2  the second vertex of the triangle
     * @param vertex3  the third vertex of the triangle
     * @param width    the width of the canvas
     * @param height   the height of the canvas
     */
    public Triangle(ColorGene color, Vertex vertex1, Vertex vertex2, Vertex vertex3, int width, int height) {
        this.color = color;
        this.vertices = new Vertex[] { vertex1, vertex2, vertex3 };
        this.width = width;
        this.height = height;
    }

    /**
     * Constructs a Triangle with random color and three random vertices within the
     * specified width and height.
     * 
     * @param width  the width of the canvas
     * @param height the height of the canvas
     */
    public Triangle(int width, int height) {
        this.color = new ColorGene(random.nextInt(256), random.nextInt(256), random.nextInt(256),
                random.nextInt(256));
        this.width = width;
        this.height = height;
        Node n1 = new Node(random.nextInt(width + 1), random.nextInt(height + 1));
        Node n2 = new Node(random.nextInt(width + 1), random.nextInt(height + 1));
        Node n3 = new Node(random.nextInt(width + 1), random.nextInt(height + 1));
        this.vertices = new Vertex[] { n1, n2, n3 };
    }

    @Override
    public ColorGene getColor() {
        return color;
    }

    @Override
    /**
     * Mutates the triangle by randomly mutating one of its vertices or its color.
     * The mutation is applied with a 50% chance to either mutate a vertex or the
     * color.
     */
    public void mutate() {
        if (random.nextBoolean()) {
            int index = random.nextInt(3);
            vertices[index].mutate();
            moveInBorder(index);
        } else {
            color.mutate();
        }
    }

    /**
     * Moves the vertex at the specified index within the bounds of the canvas.
     * 
     * @param index
     */
    private void moveInBorder(int index) {
        Vertex vertex = vertices[index];
        int x = vertex.getX();
        int y = vertex.getY();
        vertex.setX(Math.min(Math.max(x, 0), width));
        vertex.setY(Math.min(Math.max(y, 0), height));
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color.getColor());
        g2d.fillPolygon(
                new int[] { vertices[0].getX(), vertices[1].getX(), vertices[2].getX() },
                new int[] { vertices[0].getY(), vertices[1].getY(), vertices[2].getY() },
                3);
    }
}
