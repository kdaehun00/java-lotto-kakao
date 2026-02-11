package lotto.domain;

import java.util.Set;

public class AnswerLotto {
    private final static int LOTTO_LENGTH = 6;

    private final LottoBalls lottoBalls;
    private final LottoNumber bonusNum;

    public AnswerLotto(Set<Integer> lottoNums, int bonusNum) {

        this.lottoBalls = new LottoBalls(lottoNums);
        this.bonusNum = new LottoNumber(bonusNum);
    }

    public LottoResult judge(LottoBalls other) {
        boolean isCorrectBonus = isBonusCorrect(other);

        int ballCount = countBall(other);

        return new LottoResult(ballCount, isCorrectBonus);
    }

    private int countBall(LottoBalls other) {
        int ballCount = 0;

        for (LottoNumber lottoNumber : this.lottoBalls.getLottoNums()) {
            if (other.getLottoNums().contains(lottoNumber)) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    private boolean isBonusCorrect(LottoBalls other) {
        for (LottoNumber lottoNumber : other.getLottoNums()) {
            if (this.bonusNum.equals(lottoNumber)) {
                return true;
            }
        }
        return false;
    }
}
