package lotto.domain;

import lotto.util.LottoAutoCreator;

public class Lotto {
    private final LottoBallList lottoNumberList;

    public Lotto() {
        this.lottoNumberList = LottoAutoCreator.lottoAutoCreate();
    }

    public Lotto(Lotto lotto) {
        this.lottoNumberList = new LottoBallList(lotto.lottoNumberList);
    }

    public LottoResult judge(AnswerLotto other) {
        return other.judge(this.lottoNumberList);
    }

    public String getLottoNumString() {
        return lottoNumberList.getLottoNumString();
    }
}
