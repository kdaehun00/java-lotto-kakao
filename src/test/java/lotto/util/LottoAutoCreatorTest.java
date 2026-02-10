package lotto.util;

import lotto.domain.LottoNumberList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoCreatorTest {

    @Test
    @DisplayName("정상적으로 로또 생성")
    void duplicatedNumberTest() {
        ArrayList<Integer> lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        LottoNumberList myLotto = new LottoNumberList(lotto);

        assertThat(myLotto.getLottoNums()).hasSize(6);
        assertThat(myLotto.getBonusNum()).isNotNull();
    }
}
