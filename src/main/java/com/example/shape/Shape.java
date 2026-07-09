package com.example.shape;

import com.example.ColorGene;
import com.example.Render;

public interface Shape extends Render {
    /**
     * Returns the color of the shape.
     * 
     * @return the color of the shape
     */
    ColorGene getColor();

    /**
     * Returns the number of vertices in the shape.
     * 
     * @return the number of vertices in the shape
     */
    public int getVertexCount();

    /**
     * Returns the vertex at the specified index.
     * 
     * @param index >= 0 and < getVertexCount() the index of the vertex to return
     * @return the vertex at the specified index
     * @throws IllegalArgumentException if the index is out of bounds
     */
    public Vertex getVertex(int index);

    /**
     * Shifts the vertex at the specified index by the specified delta values.
     * If the resulting vertex is outside the bounds of the canvas, it will be
     * clamped to the nearest edge.
     * 
     * @param index  the index of the vertex to shift
     * @param deltaX the amount to shift the vertex in the x direction
     * @param deltaY the amount to shift the vertex in the y direction
     * @throws IllegalArgumentException if the index is out of bounds
     */
    public void shiftVertex(int index, int deltaX, int deltaY);

    /**
     * Sets the vertex at the specified index to a new vertex.
     * If the resulting vertex is outside the bounds of the canvas, it will be
     * clamped to the nearest edge.
     * 
     * @param index     the index of the vertex to set
     * @param newVertex the new vertex to set
     * @throws IllegalArgumentException if the index is out of bounds
     */
    public void setVertex(int index, Vertex newVertex);
}
