package lotto.domain;

import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class LottoBallList extends LottoNumberList {
    protected final static int LOTTO_LENGTH = 6;

    public LottoBallList(ArrayList<Integer> lottoNums) {
        Set<Integer> numSet = new LinkedHashSet<>();

        for (int i = 0; i < LOTTO_LENGTH; i++) {
            int currentNum = lottoNums.get(i);
            numSet.add(currentNum);

            this.lottoNums.add(new LottoNumber(currentNum));
        }

        checkLottoLength(numSet);
    }

    public LottoBallList(LottoBallList other) {
        this.lottoNums = new ArrayList<>(other.lottoNums);
    }

    private static void checkLottoLength(Set<Integer> numSet) {
        if (!(numSet.size() == LOTTO_LENGTH)) {
            throw new LottoException(ExceptionCode.NUMBER_DUPLICATED);
        }
    }

    public ArrayList<LottoNumber> getLottoNums() {
        return lottoNums;
    }

    public String getLottoNumString() {
        return lottoNums.toString();
    }
}
