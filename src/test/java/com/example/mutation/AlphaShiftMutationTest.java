package com.example.mutation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import java.util.Random;
import org.junit.jupiter.api.Test;
import com.example.ColorGene;
import com.example.shape.Triangle;
import com.example.shape.Vertex;

class AlphaShiftMutationTest {
    @Test
    void appliesRandomShiftToAlphaChannel() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(20, 180)).thenReturn(50);
        AlphaShiftMutation mutation = new AlphaShiftMutation(mockRandom);

        ColorGene color = mock(ColorGene.class);
        Triangle triangle = mock(Triangle.class);
        when(triangle.getColor()).thenReturn(color);

        mutation.apply(triangle);

        verify(mockRandom).nextInt(20, 180);
        verify(color).shiftChannel(3, 50);
        verifyNoMoreInteractions(color);
    }

    @Test
    void alphaIncreasesByShiftAmountOnRealColorGene() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(20, 180)).thenReturn(40);
        AlphaShiftMutation mutation = new AlphaShiftMutation(mockRandom);

        Triangle triangle = new Triangle(
                new ColorGene(10, 20, 30, 100), // r,g,b,alpha
                new Vertex(0, 0), new Vertex(1, 0), new Vertex(0, 1),
                100, 100);

        mutation.apply(triangle);

        ColorGene c = triangle.getColor();
        assertEquals(10, c.getRed());
        assertEquals(20, c.getGreen());
        assertEquals(30, c.getBlue());
        assertEquals(140, c.getAlpha()); // 100 + 40
    }
}
