package com.example;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class ImageDisplayer {
    private final CanvasPanel panel;

    public ImageDisplayer(BufferedImage image) {
        panel = new CanvasPanel(image);

        JFrame frame = new JFrame("Current Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
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