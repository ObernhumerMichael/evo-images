package com.example.mutation;

import java.util.Random;

import com.example.ColorGene;

public class HardColorShiftMutation implements ShapeMutationOperator {
    private static final Random random = new Random();

    /**
     * Applies a hard color shift to the shape's color.
     * The shift is a random integer between 0 and the maximum color value.
     *
     * @param shape the shape to apply the mutation to
     */
    @Override
    public void apply(com.example.shape.Shape shape) {
        int colorIndex = random.nextInt(3);
        int value = random.nextInt(0, ColorGene.MAX_COLOR_VALUE + 1);
        shape.getColor().setChannel(colorIndex, value);
    }

}
