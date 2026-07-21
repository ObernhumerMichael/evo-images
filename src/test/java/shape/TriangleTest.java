package shape;

import com.example.ColorGene;
import com.example.shape.Triangle;
import com.example.shape.Vertex;

import org.junit.jupiter.api.Test;

import java.awt.Graphics2D;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TriangleTest {
    @Test
    void constructorStoresValues() {
        ColorGene color = new ColorGene(10, 20, 30, 40);
        Vertex v1 = new Vertex(1, 2);
        Vertex v2 = new Vertex(3, 4);
        Vertex v3 = new Vertex(5, 6);

        Triangle triangle = new Triangle(color, v1, v2, v3, 100, 100);

        assertSame(color, triangle.getColor());
        assertEquals(3, triangle.getVertexCount());

        assertEquals(v1, triangle.getVertex(0));
        assertEquals(v2, triangle.getVertex(1));
        assertEquals(v3, triangle.getVertex(2));
    }

    @Test
    void randomConstructorCreatesThreeVerticesInsideBounds() {
        int width = 100;
        int height = 50;

        Triangle triangle = new Triangle(width, height);

        assertNotNull(triangle.getColor());
        assertEquals(3, triangle.getVertexCount());

        for (int i = 0; i < triangle.getVertexCount(); i++) {
            Vertex v = triangle.getVertex(i);

            assertTrue(v.getX() >= 0);
            assertTrue(v.getX() <= width);

            assertTrue(v.getY() >= 0);
            assertTrue(v.getY() <= height);
        }
    }

    @Test
    void shiftVertexMovesVertexInsideBounds() {
        Triangle triangle = new Triangle(
                new ColorGene(1, 2, 3, 4),
                new Vertex(10, 20),
                new Vertex(30, 40),
                new Vertex(50, 60),
                100,
                100);

        triangle.shiftVertex(0, 5, -10);

        Vertex shifted = triangle.getVertex(0);

        assertEquals(15, shifted.getX());
        assertEquals(10, shifted.getY());
    }

    @Test
    void shiftVertexClampsLowerBounds() {
        Triangle triangle = new Triangle(
                new ColorGene(1, 2, 3, 4),
                new Vertex(10, 20),
                new Vertex(30, 40),
                new Vertex(50, 60),
                100,
                100);

        triangle.shiftVertex(0, -1000, -1000);

        Vertex shifted = triangle.getVertex(0);

        assertEquals(0, shifted.getX());
        assertEquals(0, shifted.getY());
    }

    @Test
    void shiftVertexClampsUpperBounds() {
        Triangle triangle = new Triangle(
                new ColorGene(1, 2, 3, 4),
                new Vertex(10, 20),
                new Vertex(30, 40),
                new Vertex(50, 60),
                100,
                100);

        triangle.shiftVertex(0, 1000, 1000);

        Vertex shifted = triangle.getVertex(0);

        assertEquals(100, shifted.getX());
        assertEquals(100, shifted.getY());
    }

    @Test
    void renderDrawsTriangleUsingGraphics() {
        ColorGene color = new ColorGene(10, 20, 30, 40);

        Triangle triangle = new Triangle(
                color,
                new Vertex(1, 2),
                new Vertex(3, 4),
                new Vertex(5, 6),
                100,
                100);

        Graphics2D graphics = mock(Graphics2D.class);

        triangle.render(graphics);

        verify(graphics).setColor(color.getColor());

        verify(graphics).fillPolygon(
                new int[] { 1, 3, 5 },
                new int[] { 2, 4, 6 },
                3);
    }

    @Test
    void getVertexReturnsCorrectVertices() {
        Triangle triangle = new Triangle(
                new ColorGene(1, 2, 3, 4),
                new Vertex(7, 8),
                new Vertex(9, 10),
                new Vertex(11, 12),
                100,
                100);

        assertEquals(7, triangle.getVertex(0).getX());
        assertEquals(8, triangle.getVertex(0).getY());

        assertEquals(9, triangle.getVertex(1).getX());
        assertEquals(10, triangle.getVertex(1).getY());

        assertEquals(11, triangle.getVertex(2).getX());
        assertEquals(12, triangle.getVertex(2).getY());
    }
}