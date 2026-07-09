import org.junit.jupiter.api.Test;

import com.example.shape.Vertex;

import static org.assertj.core.api.Assertions.*;

class VertexTest {
    @Test
    void testVertexCreation() {
        Vertex node = new Vertex(1, 2);
        assertThat(node.getX()).isEqualTo(1);
        assertThat(node.getY()).isEqualTo(2);
    }

    @Test
    void testVertexDistance() {
        Vertex node1 = new Vertex(1, 2);
        Vertex node2 = new Vertex(4, 6);
        int expectedDistanceSquared = (4 - 1) * (4 - 1) + (6 - 2) * (6 - 2); // (3^2 + 4^2) = 25
        assertThat(node1.distanceTo(node2)).isEqualTo(expectedDistanceSquared);
    }
}
