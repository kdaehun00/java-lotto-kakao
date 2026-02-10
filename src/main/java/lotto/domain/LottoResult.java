package lotto.domain;

public class LottoResult {
    private final int ballCount;
    private final boolean isCorrectBonus;

    public LottoResult(int ballCount, boolean isCorrectBonus) {
        this.ballCount = ballCount;
        this.isCorrectBonus = isCorrectBonus;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isCorrectBonus() {
        return isCorrectBonus;
    }

    public Rank calResult() {
        if (ballCount == 6) {
            return Rank.FIRST;
        }
        if (ballCount == 5 && isCorrectBonus) {
            return Rank.SECOND;
        }
        if (ballCount == 5) {
            return Rank.THIRD;
        }
        if (ballCount == 4) {
            return Rank.FOURTH;
        }
        if (ballCount == 3) {
            return Rank.FIFTH;
        }
        return Rank.MISS;
    }
}
