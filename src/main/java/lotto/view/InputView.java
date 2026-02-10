package lotto.view;

import lotto.util.Splitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class InputView {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int readPurchaseAmount() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public ArrayList<Integer> readWinningNumbers() throws IOException {
        return Splitter.splitNumbers(br.readLine());
    }

    public int readBonusNumber() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
