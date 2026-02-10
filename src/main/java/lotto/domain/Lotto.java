package lotto.domain;

import lotto.util.LottoAutoCreator;

public class Lotto {
    private final LottoBallList lottoBallList;

    public Lotto() {
        this.lottoBallList = LottoAutoCreator.lottoAutoCreate();
    }

    public Lotto(Lotto lotto) {
        this.lottoBallList = new LottoBallList(lotto.lottoBallList);
    }

    public LottoBallList getLottoBallList() {
        return lottoBallList;
    }

    public String getLottoNumString() {
        return lottoBallList.getLottoNumString();
    }
}
