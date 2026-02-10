package lotto.util;

import lotto.domain.LottoNumberList;
import java.util.ArrayList;
import java.util.Collections;

public class LottoAutoCreator {

    public static LottoNumberList lottoAutoCreate() {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        ArrayList<Integer> result = new ArrayList<>(numbers.subList(0, 7));

        return new LottoNumberList(result);
    }
}