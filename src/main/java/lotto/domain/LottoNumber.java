package lotto.domain;

import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new LottoException(ExceptionCode.INVALID_NUMBER_RANGE);
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LottoNumber that = (LottoNumber) obj;
        return number == that.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
