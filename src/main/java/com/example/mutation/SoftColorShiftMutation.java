package com.example.mutation;

import java.util.Random;
import com.example.shape.Triangle;

public class SoftColorShiftMutation implements ShapeMutationOperator {
    private static final int MAX_SOFT_SHIFT = 15;
    private final Random random;

    public SoftColorShiftMutation(Random random) {
        this.random = random;
    }

    /**
     * Applies a soft color shift to the shape's color.
     * The shift is a random integer between -MAX_SOFT_SHIFT and MAX_SOFT_SHIFT.
     *
     * @param shape the shape to apply the mutation to
     */
    @Override
    public void apply(Triangle triangle) {
        int colorIndex = random.nextInt(3);
        int shift = random.nextInt(-MAX_SOFT_SHIFT, MAX_SOFT_SHIFT);
        triangle.getColor().shiftChannel(colorIndex, shift);
    }
}
