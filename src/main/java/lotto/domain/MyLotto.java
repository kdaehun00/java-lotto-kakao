package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.LottoAutoCreator.lottoAutoCreate;

public class MyLotto {
    private final List<Lotto> myLottoList = new ArrayList<>();

    public MyLotto(int size) {
        for (int i = 0; i < size; i++) {
            myLottoList.add(lottoAutoCreate());
        }
    }

    public int getSize() {
        return this.myLottoList.size();
    }

    public Lotto getMyLotto(int index) {
        return this.myLottoList.get(index);
    }

    public String getMyLottoStringType() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : myLottoList) {
            sb.append(lotto.getLottoString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
