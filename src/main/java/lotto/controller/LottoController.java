package lotto.controller;

import lotto.domain.AnswerLotto;
import lotto.domain.LottoResultList;
import lotto.domain.LottoTotalResult;
import lotto.domain.MyLotto;
import lotto.view.InputView;
import lotto.view.OutputMessage;
import lotto.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public static void main(String[] args) throws IOException {
        new LottoController().run();
    }

    public void run() throws IOException {
        MyLotto myLotto = makeMyLotto();

        printMyLotto(myLotto);

        AnswerLotto answerLotto = setAnswer();

        LottoResultList answer = new LottoResultList(myLotto, answerLotto);

        LottoTotalResult answer2 = new LottoTotalResult(answer);
        outputView.write(answer2.getTotalResultString());
    }

    private AnswerLotto setAnswer() throws IOException {
        outputView.write(OutputMessage.INPUT_WINNING_NUMBERS);
        ArrayList<Integer> answerList = inputView.readWinningNumbers();

        outputView.write(OutputMessage.INPUT_BONUS_NUMBER);
        int bonusNum = inputView.readBonusNumber();
        answerList.add(bonusNum);

        return new AnswerLotto(answerList);
    }

    private void printMyLotto(MyLotto myLotto) throws IOException {
        String myLottoString = myLotto.getMyLottoStringType();
        outputView.write(OutputMessage.LOTTO_LIST, myLottoString);
    }

    private MyLotto makeMyLotto() throws IOException {
        outputView.write(OutputMessage.INPUT_PURCHASE_AMOUNT);

        int count = inputView.readPurchaseAmount() / 1000;

        MyLotto myLotto = new MyLotto(count);
        outputView.write(OutputMessage.PURCHASE_COUNT, count);
        return myLotto;
    }
}
