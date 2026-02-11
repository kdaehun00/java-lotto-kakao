package lotto.domain;

import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LottoNumberListTest {

    @Test
    @DisplayName("로또 번호 중복 테스트")
    void lottoNumberDuplicatedTest() {
        ArrayList<Integer> lottoNums = new ArrayList<>(List.of(1, 2, 3, 4, 4, 5));

        assertThatThrownBy(() -> new LottoBalls(lottoNums))
                .isInstanceOf(LottoException.class)
                .hasMessage(ExceptionCode.NUMBER_DUPLICATED.getMsg());
    }

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void lottoNumberCreateTest() {
        ArrayList<Integer> lottoNums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        assertThatCode(() -> new LottoBalls(lottoNums))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호 일치 개수 검증")
    void judgeLottoNum() {
        AnswerLotto targetLotto = new AnswerLotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 10, 7)));
        LottoBalls userLotto = new LottoBalls(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));

        LottoResult lottoResult = targetLotto.judge(userLotto);

        assertThat(lottoResult.getBallCount()).isEqualTo(5);
        assertThat(lottoResult.isCorrectBonus()).isFalse();
    }

    @Test
    @DisplayName("로또 숫자 가져오기")
    void getLottoNumList(){
        ArrayList<Integer> lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        LottoBalls myLotto = new LottoBalls(lotto);
        String targetNumString = "[1, 2, 3, 4, 5, 6]";
        String lottoNumString = myLotto.getLottoNumString();

        assertThat(lottoNumString).isEqualTo(targetNumString);
    }
}
