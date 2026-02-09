import java.util.ArrayList;
import java.util.Arrays;

public class TextNumValue {
    private ArrayList<Integer> textArr = new ArrayList<>();
    private int totalValue;

    public TextNumValue(String input) {
        if (input == null) {
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            int parseResult = parseInt(input.charAt(i));

            if (parseResult >= 0) {
                totalValue += parseResult;
                textArr.add(parseResult);
            }
        }
    }

    private int parseInt(char inputValue) {
        int value = inputValue - '0';

        if (value >= 0 && value <= 9) {
            return value;
        }
        return -1;
    }

    public int getValue() {
        return this.totalValue;
    }

    public int[] getIntArr() {
        int[] arr = new int[textArr.size()];

        for (int i = 0; i < textArr.size(); i++) {
            arr[i] = textArr.get(i);
        }
        return arr;
    }
}
