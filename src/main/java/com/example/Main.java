package com.example;

import java.io.IOException;

public class Main {
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

        Genome genome;
        ImageRenderer generator = new ImageRenderer(width, height);
        ImageDisplayer targetDisplayer = new ImageDisplayer(generator.getImage());
        ImageDisplayer originalDispalyer = new ImageDisplayer(target.getImage());
        FitnessEvaluator renderer = new FitnessEvaluator(target.getPixels());

        originalDispalyer.display();
        for (int i = 0; i < 10; i++) {
            genome = new Genome(width, height, 15);
            generator.render(genome);
            long ssd = renderer.evaluate(generator.getPixels());
            System.out.println(ssd);
            targetDisplayer.display();
            sleep();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(400); // Pauses for 1000 milliseconds (1 second)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}