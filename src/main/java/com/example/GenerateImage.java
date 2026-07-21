package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Image generator for {@code Renderable} objects.
 */
class GenerateImage {
    private final Graphics2D g2d;
    private final BufferedImage canvas;
    private final int height;
    private final int width;

    private CanvasPanel panel;

    /**
     * Creates a new {@code GenerateImgae} object and initiates the display window.
     * 
     * @param width  the window width; {@code width > 0}
     * @param height the window heigth; {@code height> 0}
     */
    public GenerateImage(int width, int height) {
        this.width = width;
        this.height = height;
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = canvas.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, width, height);

        initWindow();
    }

    private void initWindow() {
        panel = new CanvasPanel(canvas);
        JFrame frame = new JFrame("Drawing Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Clears the canvas and draws the {@pcode motive} onto it.
     * 
     * @param motive the object that should be draws; {@code motive != null}
     */
    public void render(Renderable motive) {
        g2d.clearRect(0, 0, width, height);
        motive.render(g2d);
    }

    /**
     * Dispalys the currently rendered object on the display window.
     */
    public void display() {
        // No new frame — just repaint the existing one, on the EDT
        SwingUtilities.invokeLater(() -> panel.repaint());
    }

    private static class CanvasPanel extends JPanel {
        private final BufferedImage image;

        CanvasPanel(BufferedImage image) {
            this.image = image;
            setPreferredSize(new java.awt.Dimension(image.getWidth(), image.getHeight()));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }
    }
}