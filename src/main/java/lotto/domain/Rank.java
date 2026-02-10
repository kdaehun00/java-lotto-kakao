package lotto.domain;

import lotto.config.LottoConfig;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0, ""),
    FIFTH("rank.fifth"),
    FOURTH("rank.fourth"),
    THIRD("rank.third"),
    SECOND("rank.second"),
    FIRST("rank.first");

    private final int countOfMatch;
    private final int winningMoney;

    Rank(String key) {
        this.countOfMatch = LottoConfig.getInt(key + ".count");
        this.winningMoney = LottoConfig.getInt(key + ".money");
    }

    Rank(int countOfMatch, int winningMoney, String message) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch && matchBonus) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }
}