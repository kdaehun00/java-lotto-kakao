package lotto.domain;

import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class LottoNumberList {
    private final static int LOTTO_NUM_COUNT = 7;
    private final static int BONUS_NUM_INDEX = 6;

    ArrayList<LottoNumber> lottoNums = new ArrayList<>();
    LottoNumber bonusNum;

    public LottoNumberList(ArrayList<Integer> lottoNums) {
        Set<Integer> numSet = new LinkedHashSet<>();

        for (int i = 0; i < LOTTO_NUM_COUNT; i++) {
            int currentNum = lottoNums.get(i);
            numSet.add(currentNum);

            this.lottoNums.add(new LottoNumber(currentNum));
        }

        if (!(numSet.size() == LOTTO_NUM_COUNT)) {
            throw new LottoException(ExceptionCode.NUMBER_DUPLICATED);
        }
        this.bonusNum = new LottoNumber(lottoNums.get(BONUS_NUM_INDEX));
    }

    public LottoResult judge(LottoNumberList other) {
        int ballCount = 0;
        boolean isCorrectBonus = false;

        for (int i = 0; i < BONUS_NUM_INDEX; i++) {
            if (Objects.equals(this.lottoNums.get(i), other.lottoNums.get(i))) {
                ballCount += 1;
            }
        }

        if (Objects.equals(this.lottoNums.get(BONUS_NUM_INDEX), other.lottoNums.get(BONUS_NUM_INDEX))) {
            isCorrectBonus = true;
        }

        return new LottoResult(ballCount, isCorrectBonus);
    }


}
