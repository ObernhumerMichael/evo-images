package shape;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.ColorGene;
import com.example.shape.Triangle;
import com.example.shape.Vertex;

class TriangleTest {
    @Test
    void testTriangleCreation() {
        ColorGene color = new ColorGene(255, 0, 0, 255); // Red color with full opacity
        Vertex vertex1 = new Vertex(0, 0);
        Vertex vertex2 = new Vertex(1, 0);
        Vertex vertex3 = new Vertex(0, 1);

        Triangle triangle = new Triangle(color, vertex1, vertex2, vertex3, 10, 10);

        ColorGene result = triangle.getColor();

        assertEquals(color, result);
    }
}
