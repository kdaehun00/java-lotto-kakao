package lotto.domain;

import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new LottoException(ExceptionCode.INVALID_NUMBER_RANGE);
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
