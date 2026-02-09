package lotto.exception;

public enum ExceptionCode {
    INVALID_NUMBER_RANGE("올바르지 않은 로또 번호입니다."),
    NUMBER_DUPLICATED("중복된 번호가 포함돼 있습니다.");

    private final String msg;

    ExceptionCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
