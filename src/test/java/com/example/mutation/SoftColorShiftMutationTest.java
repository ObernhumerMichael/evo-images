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

class SoftColorShiftMutationTest {
    @Test
    void picksChannelThenShiftAndAppliesInOrder() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(3)).thenReturn(0); // red
        when(mockRandom.nextInt(-15, 15)).thenReturn(-7);

        SoftColorShiftMutation mutation = new SoftColorShiftMutation(mockRandom);

        ColorGene color = mock(ColorGene.class);
        Triangle triangle = mock(Triangle.class);
        when(triangle.getColor()).thenReturn(color);

        mutation.apply(triangle);

        InOrder inOrder = inOrder(mockRandom, color);
        inOrder.verify(mockRandom).nextInt(3);
        inOrder.verify(mockRandom).nextInt(-15, 15);
        inOrder.verify(color).shiftChannel(0, -7);
        verifyNoMoreInteractions(color);
    }

    @Test
    void shiftsCorrectChannelOnRealColorGene() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(3)).thenReturn(1); // green
        when(mockRandom.nextInt(-15, 15)).thenReturn(9);

        SoftColorShiftMutation mutation = new SoftColorShiftMutation(mockRandom);

        Triangle triangle = new Triangle(
                new ColorGene(10, 20, 30, 255),
                new Vertex(0, 0), new Vertex(1, 0), new Vertex(0, 1),
                100, 100);

        mutation.apply(triangle);

        ColorGene c = triangle.getColor();
        assertEquals(10, c.getRed());
        assertEquals(29, c.getGreen()); // 20 + 9
        assertEquals(30, c.getBlue());
        assertEquals(255, c.getAlpha()); // untouched
    }
}
