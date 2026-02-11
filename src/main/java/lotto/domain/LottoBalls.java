package lotto.domain;

import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoBalls extends LottoNumbers {
    private final static int LOTTO_LENGTH = 6;

    public LottoBalls(Set<Integer> lottoNums) {
        checkLottoLength(lottoNums);

        this.lottoNums = lottoNums.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public LottoBalls(LottoBalls other) {
        this.lottoNums = new LinkedHashSet<>(other.lottoNums);
    }

    private static void checkLottoLength(Set<Integer> numSet) {
        if (!(numSet.size() == LOTTO_LENGTH)) {
            throw new LottoException(ExceptionCode.INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    public Set<LottoNumber> getLottoNums() {
        return lottoNums;
    }

    public String getLottoNumString() {
        return lottoNums.toString();
    }
}
