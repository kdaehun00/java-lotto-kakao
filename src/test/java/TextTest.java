import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextTest {

    @Test
    @DisplayName("빈 문자열 -> 0 반환")
    void emptyCharTest() {
        Text text = new Text("");

        assertThat(text.getValue()).isZero();
    }

    @Test
    @DisplayName("null -> 0 반환")
    void emptyNullTest() {
        Text text = new Text(null);

        assertThat(text.getValue()).isZero();
    }

    @Test
    @DisplayName("문자열(숫자 하나)을 int type으로 변환")
    void parseStringToIntTest() {
        Text text = new Text("1");

        assertThat(text.getValue()).isEqualTo(1);
    }
}
