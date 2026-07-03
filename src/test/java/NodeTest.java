import com.example.Node;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class NodeTest {
    @Test
    public void testNodeCreation() {
        Node node = new Node(1, 2);
        assertThat(node.getX()).isEqualTo(1);
        assertThat(node.getY()).isEqualTo(2);
    }

    @Test
    public void testNodeDistance() {
        Node node1 = new Node(1, 2);
        Node node2 = new Node(4, 6);
        int expectedDistanceSquared = (4 - 1) * (4 - 1) + (6 - 2) * (6 - 2); // (3^2 + 4^2) = 25
        assertThat(node1.distanceTo(node2)).isEqualTo(expectedDistanceSquared);
    }

    @Test
    public void testNodeMutation() {
        Node node = new Node(1, 2);
        int originalX = node.getX();
        int originalY = node.getY();
        node.mutate();
        // After mutation, the node's coordinates should have changed
        assertThat(node.getX()).isNotEqualTo(originalX);
        assertThat(node.getY()).isNotEqualTo(originalY);
    }
}
