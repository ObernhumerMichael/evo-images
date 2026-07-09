package com.example.shape;

import java.awt.Graphics2D;
import java.util.Random;

import com.example.ColorGene;

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
        Vertex n1 = new Vertex(random.nextInt(width + 1), random.nextInt(height + 1));
        Vertex n2 = new Vertex(random.nextInt(width + 1), random.nextInt(height + 1));
        Vertex n3 = new Vertex(random.nextInt(width + 1), random.nextInt(height + 1));
        this.vertices = new Vertex[] { n1, n2, n3 };
    }

    @Override
    public ColorGene getColor() {
        return color;
    }

    @Override
    public int getVertexCount() {
        return vertices.length;
    }

    @Override
    public Vertex getVertex(int index) {
        validateIndex(index);
        return vertices[index];
    }

    @Override
    public void shiftVertex(int index, int deltaX, int deltaY) {
        validateIndex(index);
        Vertex v = vertices[index];
        vertices[index] = clampedVertex(v.getX() + deltaX, v.getY() + deltaY);
    }

    @Override
    public void setVertex(int index, Vertex newVertex) {
        validateIndex(index);
        vertices[index] = clampedVertex(newVertex.getX(), newVertex.getY());
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= getVertexCount()) {
            throw new IllegalArgumentException("Index out of bounds: " + index);
        }
    }

    private Vertex clampedVertex(int x, int y) {
        return new Vertex(Math.clamp(x, 0, width), Math.clamp(y, 0, height));
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(color.getColor());
        g2d.fillPolygon(
                new int[] { vertices[0].getX(), vertices[1].getX(), vertices[2].getX() },
                new int[] { vertices[0].getY(), vertices[1].getY(), vertices[2].getY() },
                3);
    }
}
