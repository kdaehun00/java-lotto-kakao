package lotto.domain;

import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AnswerLotto extends LottoNumbers{
    private final static int LOTTO_LENGTH = 6;

    private final LottoNumber bonusNum;

    public AnswerLotto(Set<Integer> lottoNums, int bonusNum) {

        checkLottoLength(lottoNums);

        this.lottoNums = lottoNums.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(HashSet::new));

        this.bonusNum = new LottoNumber(bonusNum);
    }

    private static void checkLottoLength(Set<Integer> numSet) {
        if ((numSet.size() != LOTTO_LENGTH)) {
            throw new LottoException(ExceptionCode.NUMBER_DUPLICATED);
        }
    }

    public LottoResult judge(LottoBalls other) {
        boolean isCorrectBonus = isBonusCorrect(other);

        int ballCount = countBall(other);

        return new LottoResult(ballCount, isCorrectBonus);
    }

    private int countBall(LottoBalls other) {
        int ballCount = 0;

        for (LottoNumber lottoNumber : this.lottoNums) {
            System.out.println(lottoNumber.getNumber() + ", " + other.getLottoNums());
            if (other.getLottoNums().contains(lottoNumber)) {
                System.out.println("test");
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
