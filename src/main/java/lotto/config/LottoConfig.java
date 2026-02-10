package lotto.config;

import java.util.ResourceBundle;

public class LottoConfig {
    private static final ResourceBundle properties = ResourceBundle.getBundle("lotto"); // 확장자 .properties는 생략

    private LottoConfig() {
    }

    public static int getInt(String key) {
        return Integer.parseInt(properties.getString(key));
    }

    public static String getString(String key) {
        try {
            return new String(properties.getString(key).getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            return properties.getString(key);
        }
    }
}