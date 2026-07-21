package com.example.mutation;

import java.util.Random;

import com.example.ColorGene;
import com.example.shape.Triangle;

public class HardColorShiftMutation implements ShapeMutationOperator {
    private final Random random;

    public HardColorShiftMutation(Random random) {
        this.random = random;
    }

    /**
     * Applies a hard color shift to the shape's color.
     * The shift is a random integer between 0 and the maximum color value.
     *
     * @param shape the shape to apply the mutation to
     */
    @Override
    public void apply(Triangle triangle) {
        int colorIndex = random.nextInt(ColorGene.ALPHA_CHANNEL);
        int value = random.nextInt(0, ColorGene.MAX_COLOR_VALUE + 1);
        triangle.getColor().setChannel(colorIndex, value);
    }

}
