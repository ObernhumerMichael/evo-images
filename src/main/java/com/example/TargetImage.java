package com.example;

import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.imageio.ImageIO;

public class TargetImage {
    private BufferedImage img;
    private int[] pixels;
    private int width;
    private int height;

    public TargetImage(String path) throws IOException {
        BufferedImage raw = ImageIO.read(new File(path));
        if (raw == null) {
            throw new IOException("No reader could decode: " + path);
        }

        width = raw.getWidth();
        height = raw.getHeight();

        // Normalize to a known int-backed type regardless of the source format
        this.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = this.img.createGraphics();
        g2d.drawImage(raw, 0, 0, null);
        g2d.dispose();

        this.pixels = ((DataBufferInt) this.img.getRaster().getDataBuffer()).getData();
    }

    public BufferedImage getImage() {
        return img;
    }

    public int[] getPixels() {
        return pixels;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
