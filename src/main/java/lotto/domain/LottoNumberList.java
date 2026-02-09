package lotto.domain;

import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class LottoNumberList {
    private final static int LOTTO_NUM_COUNT = 7;
    private final static int BONUS_NUM_INDEX = 6;

    ArrayList<LottoNumber> lottoNums = new ArrayList<>();
    LottoNumber bonusNum;

    public LottoNumberList(ArrayList<Integer> lottoNums) {
        Set<Integer> numSet = new LinkedHashSet<>();

        for (int i = 0; i < LOTTO_NUM_COUNT; i++) {
            numSet.add(lottoNums.get(i));
        }

        if (!(numSet.size() == LOTTO_NUM_COUNT)) {
            throw new LottoException(ExceptionCode.NUMBER_DUPLICATED);
        }
        this.bonusNum = new LottoNumber(lottoNums.get(BONUS_NUM_INDEX));
    }


}
