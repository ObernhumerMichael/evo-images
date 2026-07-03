package com.example;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.nio.file.Path;

import javax.imageio.ImageIO;

public class Director {
    private BufferedImage original;
    private int[] originalPixels;
    private final int population;
    private final int selectionPressure;
    private Genome[] genomes;
    private int shapeCount = 20;

    /**
     * Constructs a Director object by loading an image from the specified file
     * path.
     *
     * @param filePath          the path to the image file
     * @param population        the number of individuals in the population
     * @param evolutions        the number of evolutions
     * @param selectionPressure the selection pressure (uses tournament selection)
     * @throws Exception if an error occurs while reading the image
     */
    public Director(Path filePath, int population, int selectionPressure) throws Exception {
        original = ImageIO.read(filePath.toFile());
        originalPixels = ((DataBufferInt) original.getRaster().getDataBuffer()).getData();
        this.population = population;
        this.selectionPressure = selectionPressure;
        this.genomes = new Genome[population];
        initializePopulation();
    }

    private void initializePopulation() {
        for (int i = 0; i < population; i++) {
            genomes[i] = new Genome(original.getWidth(), original.getHeight(), shapeCount);
        }
    }
}
