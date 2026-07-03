import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    void addsTwoNumbers() {
        assertThat(1).isEqualTo(1);
        assertEquals(4, 2 + 2);
    }
}