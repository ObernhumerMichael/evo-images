package com.example;

import java.awt.Graphics2D;

public interface Render {
    /**
     * Draws the shape on the specified Graphics2D object.
     * 
     * @param g2d the Graphics2D object to draw the shape on
     */
    void render(Graphics2D g2d);

}
