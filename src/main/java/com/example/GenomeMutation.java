package com.example;

import com.example.mutation.ShapeMutationOperator;
import com.example.shape.Triangle;
import java.util.Random;

public class GenomeMutation {

  private final Random random;
  private final double mutationRate;
  private final ShapeMutationOperator operator;

  public GenomeMutation(Random random, double mutationRate, ShapeMutationOperator operator) {
    this.random = random;
    this.mutationRate = mutationRate;
    this.operator = operator;
  }

  public void mutate(Genome genome) {
    for (Triangle triangle : genome.getTriangles()) {
      if (random.nextDouble() < mutationRate) {
        operator.apply(triangle);
      }
    }
  }
}
