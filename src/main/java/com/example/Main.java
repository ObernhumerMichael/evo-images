package com.example;

import com.example.mutation.ShapeMutationStrategy;
import java.io.IOException;
import java.util.Random;

public class Main {

  public static int SHAPE_COUNT = 10;
  public static int POPULATION_COUNT = 200;
  public static int PRESSURE = 10;
  public static int SELECTION = 10;

  public static void main(String[] args) {
    Random random = new Random();
    String path = "./images/example-01.png";
    TargetImage target;
    try {
      target = new TargetImage(path);
      ImageDisplayer original = new ImageDisplayer(target.getImage(), "Original");
      original.display();
    } catch (IOException e) {
      System.err.println(e.getMessage());
      System.out.println("The target img could not be loaded.");
      return;
    }

    int width = target.getWidth();
    int height = target.getHeight();

    ImageRenderer renderer = new ImageRenderer(width, height);
    ImageDisplayer generated = new ImageDisplayer(renderer.getImage(), "Generated");
    FitnessEvaluator evaluator = new FitnessEvaluator(target.getPixels());
    Population population = new Population(POPULATION_COUNT, width, height, SHAPE_COUNT);
    Selection selection = new Selection(random, PRESSURE, SELECTION);
    GenomeMutation mutation = new GenomeMutation(random, 0.3, new ShapeMutationStrategy(random));

    long lastFitness = 1;
    for (int i = 0; i < 1200; i++) {
      for (Genome genome : population.getGenomes()) {
        renderer.render(genome);
        long fitness = evaluator.evaluate(renderer.getPixels());
        genome.setFitness(fitness);
      }

      Genome[] parents = selection.select(population);

      population.repopulate(parents);

      for (Genome genome : population.getGenomes()) {
        mutation.mutate(genome);
      }

      if (i % 10 == 0) {
        int bestIndex = 0;
        for (int j = 0; j < parents.length; j++) {
          if (parents[j].getFitness() < parents[bestIndex].getFitness()) {
            bestIndex = j;
          }
        }

        long fitness = parents[bestIndex].getFitness();
        long improvement = (lastFitness - fitness) * 100 / lastFitness;
        lastFitness = fitness;
        System.out.println(
            "Gen: " + i + " Fitness: " + fitness + " Improvement: " + improvement + "%");
        renderer.render(parents[0]);
        generated.display();
      }
    }

    System.out.println("Completed");
  }
}
