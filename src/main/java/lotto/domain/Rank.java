package lotto.domain;

import lotto.config.LottoConfig;

public enum Rank {
    MISS(0, 0),
    FIFTH("rank.fifth"),
    FOURTH("rank.fourth"),
    THIRD("rank.third"),
    SECOND("rank.second"),
    FIRST("rank.first");

    private final int ranking;
    private final int winningMoney;

    Rank(String key) {
        this.ranking = LottoConfig.getInt(key + ".ranking");
        this.winningMoney = LottoConfig.getInt(key + ".money");
    }

    Rank(int ranking, int winningMoney) {
        this.ranking = ranking;
        this.winningMoney = winningMoney;
    }

    public int getRanking() {
        return ranking;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}