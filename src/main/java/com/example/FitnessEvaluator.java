package com.example;

public class FitnessEvaluator {
    private final int[] targetPixels;

    public FitnessEvaluator(int[] targetPixels) {
        this.targetPixels = targetPixels;
    }

    public long evaluate(int[] candiatePixels) {
        return calculateSSD(targetPixels, candiatePixels);
    }

    private long calculateSSD(int[] targetPixels, int[] candidatePixels) {
        if (targetPixels.length != candidatePixels.length) {
            throw new IllegalArgumentException("Images have different sizes.");
        }

        long ssd = 0;

        for (int i = 0; i < targetPixels.length; i++) {
            int p1 = targetPixels[i];
            int p2 = candidatePixels[i];

            int r1 = (p1 >> 16) & 0xFF;
            int g1 = (p1 >> 8) & 0xFF;
            int b1 = p1 & 0xFF;

            int r2 = (p2 >> 16) & 0xFF;
            int g2 = (p2 >> 8) & 0xFF;
            int b2 = p2 & 0xFF;

            int dr = r1 - r2;
            int dg = g1 - g2;
            int db = b1 - b2;

            ssd += (long) dr * dr;
            ssd += (long) dg * dg;
            ssd += (long) db * db;
        }

        return ssd;
    }
}