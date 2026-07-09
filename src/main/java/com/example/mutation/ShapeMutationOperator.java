package com.example.mutation;

import com.example.shape.Shape;

public interface ShapeMutationOperator {
    /**
     * Applies a mutation to the given shape.
     * 
     * @param shape the shape to mutate
     */
    void apply(Shape shape);
}
