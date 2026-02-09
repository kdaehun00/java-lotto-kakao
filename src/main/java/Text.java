public class Text {

    private final int value;

    public Text(String inputValue) {
        this.value = parseInt(inputValue);
    }

    public int getValue() {
        return this.value;
    }

    public int parseInt(String inputValue) {
        if (inputValue == null || inputValue.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(inputValue);
    }
}
