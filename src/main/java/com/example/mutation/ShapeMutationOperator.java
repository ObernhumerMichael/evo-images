package com.example.mutation;

import com.example.shape.Triangle;

public interface ShapeMutationOperator {
    /**
     * Applies a mutation to the given shape.
     * 
     * @param triangle the tirangle to mutate
     */
    void apply(Triangle triangle);
}
