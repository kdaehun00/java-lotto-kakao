package lotto.domain;

import java.util.ArrayList;

public class LottoResultList {
    ArrayList<LottoResult> lottoResults = new ArrayList<>();

    public LottoResultList() {
    }

    public void add(LottoResult lottoResult) {
        lottoResults.add(lottoResult);
    }
}
