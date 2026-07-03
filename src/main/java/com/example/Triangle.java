package com.example;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements Shape, Gene {
    private ColorGene color;
    private Vertex vertex1;
    private Vertex vertex2;
    private Vertex vertex3;

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
     */
    public Triangle(ColorGene color, Vertex vertex1, Vertex vertex2, Vertex vertex3) {
        this.color = color;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    @Override
    public ColorGene getColor() {
        return color;
    }

    @Override
    public List<Vertex> getVertices() {
        return new ArrayList<Vertex>() {
            {
                add(vertex1);
                add(vertex2);
                add(vertex3);
            }
        };
    }

    @Override
    public void mutate() {
        // Implementation for mutating the triangle gene
    }
}
