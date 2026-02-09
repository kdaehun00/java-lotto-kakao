package lotto.domain;

import lotto.exception.ExceptionCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 범위 검증 - 실패")
    void lottoNumRange() {
        assertThatThrownBy(() -> new LottoNumber(50))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ExceptionCode.INVALID_NUMBER_RANGE.getMsg());
    }

    @Test
    @DisplayName("로또 번호 범위 검증 - 성공")
    void lottoNumRangeSuccess() {
        LottoNumber lottoNumber = new LottoNumber(44);
    }
}
