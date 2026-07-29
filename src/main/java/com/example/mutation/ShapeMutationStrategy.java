package com.example.mutation;

import com.example.shape.Triangle;
import java.util.Random;

public class ShapeMutationStrategy implements ShapeMutationOperator {
  private final Random random;

  public ShapeMutationStrategy(Random random) {
    this.random = random;
  }

  public void apply(Triangle triangle) {
    switch (random.nextInt(5)) {
      case 0:
        (new AlphaShiftMutation(random)).apply(triangle);
        break;
      case 1:
        (new HardColorShiftMutation(random)).apply(triangle);
        break;
      case 2:
        (new SoftColorShiftMutation(random)).apply(triangle);
        break;
      case 3:
        (new VertexJitterMutation(random)).apply(triangle);
        break;
      case 4:
        (new VertexJitterMutation(random)).apply(triangle);
        break;

      default:
        break;
    }
  }
}
