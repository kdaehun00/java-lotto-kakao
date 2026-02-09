import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextTest {

    @Test
    @DisplayName("빈 문자열 -> 0 반환")
    void emptyCharTest() {
        Text text = new Text("");

        assertThat(text.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("null -> 0 반환")
    void emptyNullTest() {
        Text text = new Text(null);

        assertThat(text.getValue()).isEqualTo(0);
    }
}
