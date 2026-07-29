package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FitnessEvaluatorTest {

  @Test
  void identicalImagesShouldHaveZeroFitness() {
    int[] target = {0x112233, 0x445566, 0x778899};

    FitnessEvaluator evaluator = new FitnessEvaluator(target);

    assertEquals(0, evaluator.evaluate(target));
  }

  @Test
  void singlePixelDifferenceShouldCalculateCorrectSSD() {
    int[] target = {0x000000};

    int[] candidate = {0x010203};

    FitnessEvaluator evaluator = new FitnessEvaluator(target);

    // (1² + 2² + 3²) = 1 + 4 + 9 = 14
    assertEquals(14, evaluator.evaluate(candidate));
  }

  @Test
  void multiplePixelsShouldCalculateCorrectSSD() {
    int[] target = {0x000000, 0xFFFFFF};

    int[] candidate = {0x010101, 0xFEFEFE};

    FitnessEvaluator evaluator = new FitnessEvaluator(target);

    // First pixel:
    // (1² + 1² + 1²) = 3
    //
    // Second pixel:
    // (1² + 1² + 1²) = 3
    //
    // Total = 6
    assertEquals(6, evaluator.evaluate(candidate));
  }

  @Test
  void emptyImagesShouldReturnZero() {
    FitnessEvaluator evaluator = new FitnessEvaluator(new int[0]);

    assertEquals(0, evaluator.evaluate(new int[0]));
  }

  @Test
  void differentSizedImagesShouldThrowException() {
    FitnessEvaluator evaluator = new FitnessEvaluator(new int[2]);

    assertThrows(IllegalArgumentException.class, () -> evaluator.evaluate(new int[3]));
  }

  @Test
  void blackVsWhiteShouldCalculateMaximumPerPixelDifference() {
    int[] target = {0x000000};

    int[] candidate = {0xFFFFFF};

    FitnessEvaluator evaluator = new FitnessEvaluator(target);

    // (255² * 3)
    long expected = 3L * 255 * 255;

    assertEquals(expected, evaluator.evaluate(candidate));
  }
}
