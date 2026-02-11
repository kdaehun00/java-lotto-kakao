package lotto.domain;

public enum Rank {

    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int ranking;
    private final int winningMoney;

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
