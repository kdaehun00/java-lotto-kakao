package lotto.domain;

import lotto.exception.ExceptionCode;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new RuntimeException(ExceptionCode.INVALID_NUMBER_RANGE.getMsg());
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
