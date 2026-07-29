package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class PopulationTest {

  @Test
  void constructorShouldCreateCorrectPopulationSize() {
    Population population = new Population(10, 100, 100, 25);

    assertEquals(10, population.getGenomes().size());
  }

  @Test
  void getBestGenomeShouldReturnGenomeWithLowestFitness() {
    Population population = new Population(3, 100, 100, 10);

    List<Genome> genomes = population.getGenomes();
    genomes.get(0).setFitness(100);
    genomes.get(1).setFitness(25);
    genomes.get(2).setFitness(75);

    assertSame(genomes.get(1), population.getBestGenome());
  }

  @Test
  void getWorstGenomeShouldReturnGenomeWithHighestFitness() {
    Population population = new Population(3, 100, 100, 10);

    List<Genome> genomes = population.getGenomes();

    genomes.get(0).setFitness(100);
    genomes.get(1).setFitness(25);
    genomes.get(2).setFitness(75);

    assertSame(genomes.get(0), population.getWorstGenome());
  }

  @Test
  void singleGenomeShouldBeBestAndWorst() {
    Population population = new Population(1, 100, 100, 10);

    Genome genome = population.getGenomes().get(0);
    genome.setFitness(42);

    assertSame(genome, population.getBestGenome());
    assertSame(genome, population.getWorstGenome());
  }
}
