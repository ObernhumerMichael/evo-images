package com.example;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int width = 800;
        int height = 600;
        BufferedImage canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = canvas.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, width, height);

        Genome genome = new Genome(width, height, 10);
        genome.draw(g2d);

        JFrame frame = new JFrame("Drawing Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(canvas)));
        frame.pack();
        frame.setVisible(true);
    }
}