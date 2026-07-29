package com.example;

import java.io.IOException;

public class Main {

  public static int SHAPE_COUNT = 10;
  public static int POPULATION_COUNT = 1000;

  public static void main(String[] args) {
    String path = "./images/example-01.png";
    TargetImage target;
    try {
      target = new TargetImage(path);
    } catch (IOException e) {
      System.err.println(e.getMessage());
      System.out.println("The target img could not be loaded.");
      return;
    }
    int width = target.getWidth();
    int height = target.getHeight();

    ImageRenderer renderer = new ImageRenderer(width, height);
    FitnessEvaluator evaluator = new FitnessEvaluator(target.getPixels());
    Population population = new Population(POPULATION_COUNT, width, height, SHAPE_COUNT);
    for (Genome genome : population.getGenomes()) {
      renderer.render(genome);
      long fitness = evaluator.evaluate(renderer.getPixels());
      genome.setFitness(fitness);
    }
    ImageDisplayer original = new ImageDisplayer(target.getImage(), "Original");
    original.display();

    renderer.render(population.getBestGenome());
    ImageDisplayer current = new ImageDisplayer(renderer.getImage(), "Generated");
    current.display();
    System.out.println("Best Fitness: " + population.getBestGenome().getFitness());
    System.out.println("Worst Fitness: " + population.getWorstGenome().getFitness());
  }

  private static void sleep() {
    try {
      Thread.sleep(1000); // Pauses for 1000 milliseconds (1 second)
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt(); // Restore interrupted status
    }
  }
}
