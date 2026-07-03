import org.junit.jupiter.api.Test;

import com.example.ColorGene;
import com.example.Node;
import com.example.Triangle;
import com.example.Vertex;

public class TriangleTest {
    @Test
    public void testTriangleCreation() {
        // Test the creation of a Triangle object
        ColorGene color = new ColorGene(255, 0, 0, 255); // Red color with full opacity
        Vertex vertex1 = new Node(0, 0);
        Vertex vertex2 = new Node(1, 0);
        Vertex vertex3 = new Node(0, 1);

        Triangle triangle = new Triangle(color, vertex1, vertex2, vertex3, 10, 10);

        assert triangle.getColor().equals(color) : "Color should match the provided color";
    }
}
