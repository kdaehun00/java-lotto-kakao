package lotto.view;

import lotto.domain.LottoNumber;
import lotto.util.Splitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class InputView {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int readPurchaseAmount() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public Set<LottoNumber> readWinningNumbers() throws IOException {
        return Splitter.splitNumbers(br.readLine()).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public int readBonusNumber() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
