package com.example;

import java.awt.Color;
import java.util.Random;

public class ColorGene implements Gene {
    private int[] rgba;
    private static final Random random = new Random();
    public static final int MAX_COLOR_VALUE = 255;
    public static final int MAX_SOFT_SHIFT = 15;

    /**
     * Constructs a Color object with the specified red, green, blue, and alpha
     * components.
     * Each component must be an integer between 0 and 255.
     */
    public ColorGene(int r, int g, int b, int alpha) {
        this.rgba = new int[] { r, g, b, alpha };
    }

    public Color getColor() {
        return new Color(rgba[0], rgba[1], rgba[2], rgba[3]);
    }

    @Override
    /**
     * Mutates the color of the triangle by randomly shifting its RGBA components.
     * The mutation can be a hard color shift, a soft color shift, or an alpha
     * shift, based on random probabilities.
     */
    public void mutate() {
        int r = random.nextInt(100);
        if (r <= 10) {
            hardColorShift(random.nextInt(3));
        } else if (r <= 40) {
            alphaShift();
        } else {
            softColorShift(random.nextInt(3));
        }
    }

    /**
     * Shifts the color of the triangle softly based on the specified color index.
     * 
     * @param colorIndex
     */
    private void softColorShift(int colorIndex) {
        int shift = random.nextInt(-MAX_SOFT_SHIFT, MAX_SOFT_SHIFT);
        rgba[colorIndex] += shift;
        rgba[colorIndex] = Math.clamp(rgba[colorIndex], 0, MAX_COLOR_VALUE); // add this

    }

    /**
     * Shifts the color of the triangle hard based on the specified color index.
     * 
     * @param colorIndex
     */
    private void hardColorShift(int colorIndex) {
        rgba[colorIndex] = random.nextInt(MAX_COLOR_VALUE + 1);
    }

    /**
     * Shifts the alpha of the triangle softly.
     */
    private void alphaShift() {
        int shift = random.nextInt(20, 180);
        rgba[3] = shift;
        rgba[3] = Math.clamp(rgba[3], 0, MAX_COLOR_VALUE); // add this
    }
}
