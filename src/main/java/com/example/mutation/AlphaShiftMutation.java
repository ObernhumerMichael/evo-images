package com.example.mutation;

import java.util.Random;
import com.example.shape.Triangle;

public class AlphaShiftMutation implements ShapeMutationOperator {
    private final Random random;

    public AlphaShiftMutation(Random random) {
        this.random = random;
    }

    /**
     * Applies a random alpha shift to the shape's color.
     * The shift is a random integer between 20 and 180.
     *
     * @param shape the shape to apply the mutation to
     */
    @Override
    public void apply(Triangle triangle) {
        int shift = random.nextInt(20, 180);
        triangle.getColor().shiftChannel(3, shift);
    }
}
