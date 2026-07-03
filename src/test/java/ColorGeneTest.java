import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import com.example.ColorGene;

public class ColorGeneTest {
    @Test
    public void testMapping() {
        ColorGene colorGene = new ColorGene(100, 150, 200, 255);
        assertThat(colorGene.getColor().getRed()).isEqualTo(100);
        assertThat(colorGene.getColor().getGreen()).isEqualTo(150);
        assertThat(colorGene.getColor().getBlue()).isEqualTo(200);
        assertThat(colorGene.getColor().getAlpha()).isEqualTo(255);
    }

    @RepeatedTest(10)
    public void mutate() {
        ColorGene colorGene = new ColorGene(100, 150, 200, 255);
        int[] originalRGBA = new int[] {
                colorGene.getColor().getRed(),
                colorGene.getColor().getGreen(),
                colorGene.getColor().getBlue(),
                colorGene.getColor().getAlpha()
        };

        // Mutate the color gene
        colorGene.mutate();
        int[] mutatedRGBA = new int[] {
                colorGene.getColor().getRed(),
                colorGene.getColor().getGreen(),
                colorGene.getColor().getBlue(),
                colorGene.getColor().getAlpha()
        };

        // Ensure that at least one of the RGBA values has changed
        boolean hasChanged = false;
        for (int i = 0; i < originalRGBA.length; i++) {
            if (originalRGBA[i] != mutatedRGBA[i]) {
                hasChanged = true;
                break;
            }
        }
        assertThat(hasChanged).isTrue();
    }
}
