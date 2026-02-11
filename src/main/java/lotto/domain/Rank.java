package lotto.domain;

public enum Rank {

    MISS(0, 0),
    FIFTH(5, 5_000),
    FOURTH(4, 50_000),
    THIRD(3, 1_500_000),
    SECOND(2, 30_000_000),
    FIRST(1, 2_000_000_000);

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
