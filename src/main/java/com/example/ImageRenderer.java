package com.example;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Image generator for {@code Renderable} objects.
 */
class ImageRenderer {
    private final Graphics2D g2d;
    private final BufferedImage canvas;
    private final int height;
    private final int width;

    /**
     * Creates a new {@code GenerateImgae} object and initiates the display window.
     * 
     * @param width  the window width; {@code width > 0}
     * @param height the window heigth; {@code height> 0}
     */
    public ImageRenderer(int width, int height) {
        this.width = width;
        this.height = height;
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = canvas.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, width, height);
    }

    /**
     * Clears the canvas and draws the {@pcode motive} onto it.
     * 
     * @param motive the object that should be draws; {@code motive != null}
     */
    public void render(Renderable motive) {
        g2d.clearRect(0, 0, width, height);
        motive.render(g2d);
    }

    public BufferedImage getImage() {
        return canvas;
    }

    public int[] getPixels() {
        return ((DataBufferInt) canvas.getRaster().getDataBuffer()).getData();
    }
}