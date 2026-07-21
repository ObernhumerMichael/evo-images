package com.example.mutation;

import java.util.Random;
import com.example.shape.Triangle;

public class VertexJitterMutation implements ShapeMutationOperator {
    private static final int MAX_JITTER = 20;
    private final Random random;

    public VertexJitterMutation(Random random) {
        this.random = random;
    }

    /**
     * Applies a random jitter to one of the shape's vertices.
     * The jitter is a random integer between -MAX_JITTER and MAX_JITTER for both
     * the x and y coordinates.
     */
    @Override
    public void apply(Triangle triangle) {
        int vertexIndex = random.nextInt(triangle.getVertexCount());
        int deltaX = random.nextInt(-MAX_JITTER, MAX_JITTER);
        int deltaY = random.nextInt(-MAX_JITTER, MAX_JITTER);
        triangle.shiftVertex(vertexIndex, deltaX, deltaY);
    }

}
