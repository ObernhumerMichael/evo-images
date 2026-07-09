package com.example.mutation;

import java.util.Random;

import com.example.shape.Shape;

public class VertexJitterMutation implements ShapeMutationOperator {
    private static final int MAX_JITTER = 20;
    private static final Random random = new Random();

    /**
     * Applies a random jitter to one of the shape's vertices.
     * The jitter is a random integer between -MAX_JITTER and MAX_JITTER for both
     * the x and y coordinates.
     */
    @Override
    public void apply(Shape shape) {
        int vertexIndex = random.nextInt(shape.getVertexCount());
        int deltaX = random.nextInt(-MAX_JITTER, MAX_JITTER);
        int deltaY = random.nextInt(-MAX_JITTER, MAX_JITTER);
        shape.shiftVertex(vertexIndex, deltaX, deltaY);
    }

}
