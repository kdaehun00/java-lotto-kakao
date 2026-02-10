package lotto.domain;

import java.util.ArrayList;

public class MyLotto {
    ArrayList<Lotto> myLottoList = new ArrayList<>();

    public MyLotto(int size) {
        for (int i = 0; i < size; i++) {
            myLottoList.add(new Lotto());
        }
    }

    public int getSize() {
        return this.myLottoList.size();
    }

    public Lotto getMyLotto(int index) {
        return new Lotto(this.myLottoList.get(index));
    }

}
