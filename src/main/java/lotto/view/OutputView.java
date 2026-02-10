package lotto.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputView {

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void write(OutputMessage outputMessage, Object... args) throws IOException {
        bw.write(outputMessage.format(args));
        bw.flush();
    }
}
