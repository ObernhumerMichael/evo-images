package com.example.shape;

import java.awt.Graphics2D;
import java.util.Random;

import com.example.ColorGene;
import com.example.Renderable;

public class Triangle implements Renderable {
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

    /**
     * Returns the color of the shape.
     * 
     * @return the color of the shape
     */
    public ColorGene getColor() {
        return color;
    }

    /**
     * Returns the number of vertices in the shape.
     * 
     * @return the number of vertices in the shape
     */
    public int getVertexCount() {
        return vertices.length;
    }

    /**
     * Returns the vertex at the specified index.
     * 
     * @param index the index of the vertex to return;
     *              {@code index >= 0 and < getVertexCount()}
     * @return the vertex at the specified index
     */
    public Vertex getVertex(int index) {
        return vertices[index];
    }

    /**
     * Shifts the vertex at the specified index by the specified delta values.
     * If the resulting vertex is outside the bounds of the canvas, it will be
     * clamped to the nearest edge.
     * 
     * @param index  the index of the vertex to shift,
     *               {@code index >= 0 and < getVertexCount()}
     * @param deltaX the amount to shift the vertex in the x direction
     * @param deltaY the amount to shift the vertex in the y direction
     */
    public void shiftVertex(int index, int deltaX, int deltaY) {
        Vertex v = vertices[index];
        vertices[index] = clampVertex(v.getX() + deltaX, v.getY() + deltaY);
    }

    private Vertex clampVertex(int x, int y) {
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
