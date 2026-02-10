package lotto.domain;

import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class LottoNumberList {
    private final static int LOTTO_LENGTH = 6;
    private final static int BONUS_NUM_INDEX = 6;

    ArrayList<LottoNumber> lottoNums = new ArrayList<>();
    LottoNumber bonusNum;

    public LottoNumberList(ArrayList<Integer> lottoNums) {
        Set<Integer> numSet = new LinkedHashSet<>();

        for (int i = 0; i < LOTTO_LENGTH; i++) {
            int currentNum = lottoNums.get(i);
            numSet.add(currentNum);

            this.lottoNums.add(new LottoNumber(currentNum));
        }

        checkLottoLength(numSet);
        this.bonusNum = new LottoNumber(lottoNums.get(BONUS_NUM_INDEX));
    }

    public LottoNumberList(LottoNumberList other) {
        this.lottoNums = new ArrayList<>(other.lottoNums);
        this.bonusNum = other.bonusNum;
    }

    private static void checkLottoLength(Set<Integer> numSet) {
        if (!(numSet.size() == LOTTO_LENGTH)) {
            throw new LottoException(ExceptionCode.NUMBER_DUPLICATED);
        }
    }

    public LottoResult judge(LottoNumberList other) {
        int ballCount = 0;
        boolean isCorrectBonus = false;

        ballCount = countBall(other, ballCount);

        isCorrectBonus = isBonusCorrect(other);

        return new LottoResult(ballCount, isCorrectBonus);
    }

    private boolean isBonusCorrect(LottoNumberList other) {
        return Objects.equals(this.bonusNum, other.bonusNum);
    }

    private int countBall(LottoNumberList other, int ballCount) {
        for (int i = 0; i < LOTTO_LENGTH; i++) {
            if (Objects.equals(this.lottoNums.get(i), other.lottoNums.get(i))) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    public ArrayList<LottoNumber> getLottoNums() {
        return lottoNums;
    }

    public LottoNumber getBonusNum() {
        return bonusNum;
    }

    public String getLottoNumString() {
        return lottoNums.toString();
    }
}
