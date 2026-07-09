import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import com.example.ColorGene;

class ColorGeneTest {
    @Test
    void testMapping() {
        ColorGene colorGene = new ColorGene(100, 150, 200, 255);
        assertThat(colorGene.getColor().getRed()).isEqualTo(100);
        assertThat(colorGene.getColor().getGreen()).isEqualTo(150);
        assertThat(colorGene.getColor().getBlue()).isEqualTo(200);
        assertThat(colorGene.getColor().getAlpha()).isEqualTo(255);
    }
}
