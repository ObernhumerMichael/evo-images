package com.example;

import java.util.List;
import java.util.Random;

public class Selection {
  private final int pressure;
  private final int select;
  private final Random random;

  public Selection(Random random, int pressure, int select) {
    this.pressure = pressure;
    this.select = select;
    this.random = random;
  }

  public Genome[] select(Population population) {
    if (population.getGenomes().isEmpty()) {
      throw new IllegalArgumentException("population must not be empty");
    }

    Genome[] selection = new Genome[select];
    List<Genome> genomes = population.getGenomes();

    for (int i = 0; i < select; i++) {
      Genome best = null;
      for (int j = 0; j < pressure; j++) {
        int index = random.nextInt(genomes.size());
        Genome candidate = genomes.get(index);
        if (best == null || best.getFitness() > candidate.getFitness()) {
          best = candidate;
        }
      }
      selection[i] = best;
    }

    return selection;
  }
}
