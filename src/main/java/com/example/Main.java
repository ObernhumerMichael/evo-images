package com.example;

public class Main {
    public static void main(String[] args) {
        int width = 800;
        int height = 600;

        Genome genome;
        GenerateImage gi = new GenerateImage(width, height);
        for (int i = 0; i < 10; i++) {
            genome = new Genome(width, height, 15);
            gi.render(genome);
            gi.display();
            sleep();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(100); // Pauses for 1000 milliseconds (1 second)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}