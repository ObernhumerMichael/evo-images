package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

class SelectionTest {

  @Test
  void shouldReturnRequestedNumberOfGenomes() {
    Random random = mock(Random.class);
    Population population = mock(Population.class);

    Genome genome = mock(Genome.class);
    when(genome.getFitness()).thenReturn(10L);

    when(population.getGenomes()).thenReturn(List.of(genome));
    when(random.nextInt(1)).thenReturn(0);

    Selection selection = new Selection(random, 1, 5);

    Genome[] result = selection.select(population);

    assertThat(result).hasSize(5);
    assertThat(result).containsOnly(genome);
  }

  @Test
  void shouldChooseGenomeWithLowestFitnessInTournament() {
    Random random = mock(Random.class);
    Population population = mock(Population.class);

    Genome bad = mock(Genome.class);
    Genome good = mock(Genome.class);

    when(bad.getFitness()).thenReturn(100L);
    when(good.getFitness()).thenReturn(10L);

    when(population.getGenomes()).thenReturn(List.of(bad, good));

    // Tournament:
    // first candidate -> bad
    // second candidate -> good
    when(random.nextInt(2)).thenReturn(0, 1);

    Selection selection = new Selection(random, 2, 1);

    Genome[] result = selection.select(population);

    assertThat(result).containsExactly(good);
  }

  @Test
  void shouldAllowSameGenomeToBeSelectedMultipleTimes() {
    Random random = mock(Random.class);
    Population population = mock(Population.class);

    Genome genome = mock(Genome.class);

    when(genome.getFitness()).thenReturn(1L);
    when(population.getGenomes()).thenReturn(List.of(genome));

    when(random.nextInt(1)).thenReturn(0);

    Selection selection = new Selection(random, 3, 4);

    Genome[] result = selection.select(population);

    assertThat(result).containsExactly(genome, genome, genome, genome);
  }

  @Test
  void shouldCallRandomPressureTimesPerSelection() {
    Random random = mock(Random.class);
    Population population = mock(Population.class);

    Genome genome = mock(Genome.class);

    when(genome.getFitness()).thenReturn(1L);
    when(population.getGenomes()).thenReturn(List.of(genome));
    when(random.nextInt(1)).thenReturn(0);

    Selection selection = new Selection(random, 4, 3);

    selection.select(population);

    verify(random, times(12)).nextInt(1);
  }

  @Test
  void shouldThrowWhenPopulationIsEmpty() {
    Random random = mock(Random.class);
    Population population = mock(Population.class);

    when(population.getGenomes()).thenReturn(List.of());

    Selection selection = new Selection(random, 2, 1);

    org.junit.jupiter.api.Assertions.assertThrows(
        IllegalArgumentException.class, () -> selection.select(population));
  }
}
