package lotto.domain;

import lotto.util.LottoAutoCreator;

public class Lotto {
    private final LottoBalls lottoBalls;

    public Lotto() {
        this.lottoBalls = LottoAutoCreator.lottoAutoCreate();
    }

    public Lotto(Lotto lotto) {
        this.lottoBalls = new LottoBalls(lotto.lottoBalls);
    }

    public LottoBalls getLottoBallList() {
        return lottoBalls;
    }

    public String getLottoNumString() {
        return lottoBalls.getLottoNumString();
    }
}
