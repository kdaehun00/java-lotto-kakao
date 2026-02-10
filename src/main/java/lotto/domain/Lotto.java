package lotto.domain;

import lotto.util.LottoAutoCreator;

public class Lotto {
    private final LottoNumberList lottoNumberList;

    public Lotto() {
        this.lottoNumberList = LottoAutoCreator.lottoAutoCreate();
    }

    public Lotto(Lotto lotto) {
        this.lottoNumberList = new LottoNumberList(lotto.lottoNumberList);
    }

    public LottoResult judge(Lotto other) {
        return this.lottoNumberList.judge(other.lottoNumberList);
    }

    public String getLottoNumString() {
        return lottoNumberList.getLottoNumString();
    }
}
