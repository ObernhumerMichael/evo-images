package com.example.mutation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import com.example.ColorGene;
import com.example.shape.Triangle;
import com.example.shape.Vertex;

class HardColorShiftMutationTest {
    @Test
    void picksChannelThenValueAndAppliesInOrder() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(ColorGene.ALPHA_CHANNEL)).thenReturn(1); // green
        when(mockRandom.nextInt(0, ColorGene.MAX_COLOR_VALUE + 1)).thenReturn(200);

        HardColorShiftMutation mutation = new HardColorShiftMutation(mockRandom);

        ColorGene color = mock(ColorGene.class);
        Triangle triangle = mock(Triangle.class);
        when(triangle.getColor()).thenReturn(color);

        mutation.apply(triangle);

        InOrder inOrder = inOrder(mockRandom, color);
        inOrder.verify(mockRandom).nextInt(ColorGene.ALPHA_CHANNEL);
        inOrder.verify(mockRandom).nextInt(0, ColorGene.MAX_COLOR_VALUE + 1);
        inOrder.verify(color).setChannel(1, 200);
        verifyNoMoreInteractions(color);
    }

    @Test
    void setsCorrectChannelOnRealColorGene() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(ColorGene.ALPHA_CHANNEL)).thenReturn(2); // blue
        when(mockRandom.nextInt(0, ColorGene.MAX_COLOR_VALUE + 1)).thenReturn(77);

        HardColorShiftMutation mutation = new HardColorShiftMutation(mockRandom);

        Triangle triangle = new Triangle(
                new ColorGene(10, 20, 30, 255),
                new Vertex(0, 0), new Vertex(1, 0), new Vertex(0, 1),
                100, 100);

        mutation.apply(triangle);

        ColorGene c = triangle.getColor();
        assertEquals(10, c.getRed());
        assertEquals(20, c.getGreen());
        assertEquals(77, c.getBlue());
        assertEquals(255, c.getAlpha()); // untouched
    }
}
