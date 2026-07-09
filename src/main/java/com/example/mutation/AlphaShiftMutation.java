package com.example.mutation;

import java.util.Random;

import com.example.shape.Shape;

public class AlphaShiftMutation implements ShapeMutationOperator {
    private static final Random random = new Random();

    /**
     * Applies a random alpha shift to the shape's color.
     * The shift is a random integer between 20 and 180.
     *
     * @param shape the shape to apply the mutation to
     */
    @Override
    public void apply(Shape shape) {
        int shift = random.nextInt(20, 180);
        shape.getColor().shiftChannel(4, shift);
    }
}
