package com.example;

import java.util.List;

public interface Shape {
    /**
     * Returns the color of the shape.
     * 
     * @return the color of the shape
     */
    ColorGene getColor();

    /**
     * Returns a list of vertices that define the shape.
     * 
     * @return a list of vertices that define the shape
     */
    List<Vertex> getVertices();
}
