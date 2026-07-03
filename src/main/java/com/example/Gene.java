package com.example;

public interface Gene {
    /**
     * Mutates the gene.
     */
    void mutate();

    /**
     * Recombines this gene with another gene.
     * 
     * @param other the other gene to recombine with
     */
    default void recombine(Gene other) {
        throw new UnsupportedOperationException("Recombination not supported for this gene type.");
    }
}
