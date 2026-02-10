package lotto.domain;

import java.util.ArrayList;

public class LottoResultList {
    ArrayList<LottoResult> lottoResults = new ArrayList<>();

    public LottoResultList(MyLotto myLotto, AnswerLotto answerLotto) {
        for (Lotto lotto : myLotto.myLottoList) {
            lottoResults.add(answerLotto.judge(lotto.getLottoBallList()));
        }
    }

    public ArrayList<Rank> getLottoResultRanks() {
        ArrayList<Rank> ranks = new ArrayList<>();

        for (LottoResult lottoResult : lottoResults) {
            ranks.add(lottoResult.calResult());
        }

        return ranks;
    }
}
