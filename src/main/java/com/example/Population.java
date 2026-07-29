package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Population {
  private final int size;
  private List<Genome> genomes;

  public Population(int size, int width, int height, int shapes) {
    this.size = size;
    genomes = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      genomes.add(new Genome(width, height, shapes));
    }
  }

  public List<Genome> getGenomes() {
    return genomes;
  }

  public Genome getBestGenome() {
    return genomes.stream().min(Comparator.comparingLong(Genome::getFitness)).orElseThrow();
  }

  public Genome getWorstGenome() {
    return genomes.stream().max(Comparator.comparingLong(Genome::getFitness)).orElseThrow();
  }

  public void repopulate(Genome[] parents) {
    int cloneCount = size / parents.length;

    genomes.clear();
    for (Genome genome : parents) {
      for (int i = 0; i < cloneCount; i++) {
        genomes.add(new Genome(genome));
      }
    }
  }
}
