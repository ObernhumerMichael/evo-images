package com.example;

import java.util.ArrayList;
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
        return genomes;
    }

    public Genome getBestGenome() {
        List<Genome> copy = new ArrayList<>(genomes);
        copy.sort(Comparator.comparingLong(Genome::getFitness));
        return copy.getFirst();
    }

    public Genome getWorstGenome() {
        List<Genome> copy = new ArrayList<>(genomes);
        copy.sort(Comparator.comparingLong(Genome::getFitness));
        return copy.getLast();
    }
}