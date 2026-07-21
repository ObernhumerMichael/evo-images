package mutation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.jupiter.api.Test;

import com.example.ColorGene;
import com.example.mutation.VertexJitterMutation;
import com.example.shape.Triangle;
import com.example.shape.Vertex;

class VertexJitterMutationTest {
    @Test
    void shiftsCorrectVertexOnRealTriangle() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(3)).thenReturn(1); // second vertex
        when(mockRandom.nextInt(-20, 20)).thenReturn(6, -3); // deltaX then deltaY

        VertexJitterMutation mutation = new VertexJitterMutation(mockRandom);

        Triangle triangle = new Triangle(
                new ColorGene(0, 0, 0, 255),
                new Vertex(50, 50), new Vertex(50, 50), new Vertex(50, 50),
                100, 100);

        mutation.apply(triangle);

        assertEquals(50, triangle.getVertex(0).getX());
        assertEquals(50, triangle.getVertex(0).getY());
        assertEquals(56, triangle.getVertex(1).getX()); // 50 + 6
        assertEquals(47, triangle.getVertex(1).getY()); // 50 - 3
        assertEquals(50, triangle.getVertex(2).getX());
        assertEquals(50, triangle.getVertex(2).getY());
    }
}
