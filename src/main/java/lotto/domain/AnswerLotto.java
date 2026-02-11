package lotto.domain;

import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class AnswerLotto extends LottoNumbers{
    protected final static int LOTTO_LENGTH = 6;

    private final static int BONUS_NUM_INDEX = 6;
    private final LottoNumber bonusNum;

    public AnswerLotto(ArrayList<Integer> lottoNums) {
        Set<Integer> numSet = new LinkedHashSet<>();

        for (int i = 0; i < LOTTO_LENGTH; i++) {
            int currentNum = lottoNums.get(i);
            numSet.add(currentNum);

            this.lottoNums.add(new LottoNumber(currentNum));
        }

        checkLottoLength(numSet);
        this.bonusNum = new LottoNumber(lottoNums.get(BONUS_NUM_INDEX));
    }

    private static void checkLottoLength(Set<Integer> numSet) {
        if (!(numSet.size() == LOTTO_LENGTH)) {
            throw new LottoException(ExceptionCode.NUMBER_DUPLICATED);
        }
    }

    public LottoResult judge(LottoBalls other) {
        int ballCount = 0;
        boolean isCorrectBonus = isBonusCorrect(other);

        ballCount = countBall(other, ballCount);

        return new LottoResult(ballCount, isCorrectBonus);
    }

    private int countBall(LottoBalls other, int ballCount) {
        for (int i = 0; i < LOTTO_LENGTH; i++) {
            if (Objects.equals(this.lottoNums.get(i), other.lottoNums.get(i))) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    private boolean isBonusCorrect(LottoBalls other) {
        for (LottoNumber lottoNumber : other.lottoNums) {
            if (this.bonusNum.equals(lottoNumber)) {
                return true;
            }
        }
        return false;
    }
}
