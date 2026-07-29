package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Population {
  private final List<Genome> genomes;

  public Population(int size, int width, int height, int shapes) {
    genomes = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      genomes.add(new Genome(width, height, shapes));
    }
  }

  public List<Genome> getGenomes() {
    return Collections.unmodifiableList(genomes);
  }

  public Genome getBestGenome() {
    return genomes.stream().min(Comparator.comparingLong(Genome::getFitness)).orElseThrow();
  }

  public Genome getWorstGenome() {
    return genomes.stream().max(Comparator.comparingLong(Genome::getFitness)).orElseThrow();
  }
}
