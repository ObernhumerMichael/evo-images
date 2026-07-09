package com.example;

import java.awt.Color;

public class ColorGene {
    private int[] rgba;
    public static final int MAX_COLOR_VALUE = 255;

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

    /**
     * Shifts a single channel by delta, clamping to [0, MAX_COLOR_VALUE].
     * 
     * @param channelIndex the index of the channel to shift (0 for red, 1 for
     *                     green, 2 for blue, 3 for alpha)
     * @param delta        the amount to shift the channel by
     */
    public void shiftChannel(int channelIndex, int delta) {
        int value = rgba[channelIndex] + delta;
        rgba[channelIndex] = Math.clamp(value, 0, MAX_COLOR_VALUE);
    }

    /**
     * Hard-sets a single channel to a random value in [0, MAX_COLOR_VALUE].
     * 
     * @param channelIndex the index of the channel to randomize (0 for red, 1 for
     *                     green, 2 for blue, 3 for alpha)
     * @param newValue     the new value for the channel
     */
    public void setChannel(int channelIndex, int newValue) {
        rgba[channelIndex] = Math.clamp(newValue, 0, MAX_COLOR_VALUE);
    }
}
