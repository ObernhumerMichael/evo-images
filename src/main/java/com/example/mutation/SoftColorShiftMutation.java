package com.example.mutation;

import java.util.Random;

import com.example.shape.Shape;

public class SoftColorShiftMutation implements ShapeMutationOperator {
    private static final int MAX_SOFT_SHIFT = 15;
    private static final Random random = new Random();

    /**
     * Applies a soft color shift to the shape's color.
     * The shift is a random integer between -MAX_SOFT_SHIFT and MAX_SOFT_SHIFT.
     *
     * @param shape the shape to apply the mutation to
     */
    @Override
    public void apply(Shape shape) {
        int colorIndex = random.nextInt(3);
        int shift = random.nextInt(-MAX_SOFT_SHIFT, MAX_SOFT_SHIFT);
        shape.getColor().shiftChannel(colorIndex, shift);
    }
}
