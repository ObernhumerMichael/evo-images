package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import org.junit.jupiter.api.Test;

class ImageRendererTest {

  @Test
  void constructorShouldCreateImageWithCorrectDimensions() {
    ImageRenderer renderer = new ImageRenderer(100, 50);

    BufferedImage image = renderer.getImage();

    assertEquals(100, image.getWidth());
    assertEquals(50, image.getHeight());
  }

  @Test
  void getImageShouldReturnSameInstance() {
    ImageRenderer renderer = new ImageRenderer(20, 20);

    BufferedImage image1 = renderer.getImage();
    BufferedImage image2 = renderer.getImage();

    assertSame(image1, image2);
  }

  @Test
  void getPixelsShouldReturnUnderlyingPixelArray() {
    ImageRenderer renderer = new ImageRenderer(10, 10);

    int[] pixels = renderer.getPixels();

    assertNotNull(pixels);
    assertEquals(100, pixels.length);
  }

  @Test
  void renderShouldInvokeRenderable() {
    ImageRenderer renderer = new ImageRenderer(10, 10);

    class TestRenderable implements Renderable {
      boolean called = false;

      @Override
      public void render(Graphics2D g2d) {
        called = true;
      }
    }

    TestRenderable renderable = new TestRenderable();

    renderer.render(renderable);

    assertTrue(renderable.called);
  }

  @Test
  void renderShouldDrawOnCanvas() {
    ImageRenderer renderer = new ImageRenderer(20, 20);

    renderer.render(
        g2d -> {
          g2d.setColor(Color.BLACK);
          g2d.fillRect(0, 0, 20, 20);
        });

    BufferedImage image = renderer.getImage();

    assertEquals(Color.BLACK.getRGB(), image.getRGB(5, 5));
  }

  @Test
  void renderShouldClearPreviousDrawing() {
    ImageRenderer renderer = new ImageRenderer(20, 20);

    renderer.render(
        g2d -> {
          g2d.setColor(Color.BLACK);
          g2d.fillRect(0, 0, 20, 20);
        });

    renderer.render(
        g2d -> {
          // Draw nothing
        });

    BufferedImage image = renderer.getImage();

    assertEquals(Color.WHITE.getRGB(), image.getRGB(5, 5));
  }
}
