package com.example;

import java.awt.Graphics2D;

public interface Shape extends Gene {
    /**
     * Returns the color of the shape.
     * 
     * @return the color of the shape
     */
    ColorGene getColor();

    /**
     * Draws the shape on the specified Graphics2D object.
     * 
     * @param g2d the Graphics2D object to draw the shape on
     */
    void draw(Graphics2D g2d);
}
