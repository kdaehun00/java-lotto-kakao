package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.LottoAutoCreator.lottoAutoCreate;

public class LottoStore {

    public MyLotto buyLotto(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i <= size; i++) {
            lottos.add(lottoAutoCreate());
        }
        return new MyLotto(lottos);
    }
}
