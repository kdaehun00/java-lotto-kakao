package lotto.util;

import lotto.domain.LottoBallList;
import java.util.ArrayList;
import java.util.Collections;

public class LottoAutoCreator {

    public static LottoBallList lottoAutoCreate() {

        return getLottoBallList(6);
    }

    public static LottoBallList lottoAnswerCreate() {

        return getLottoBallList(7);
    }

    private static LottoBallList getLottoBallList(int toIndex) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        ArrayList<Integer> result = new ArrayList<>(numbers.subList(0, toIndex));
        Collections.sort(result);

        return new LottoBallList(result);
    }
}