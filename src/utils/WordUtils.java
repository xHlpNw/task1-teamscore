package utils;

public class WordUtils {
    public static String getWordForm(long n, String form1, String form2, String form5) {
        if (n % 100 >= 11 && n % 100 <= 14) return form5;
        return switch ((int)(n % 10)) {
            case 1 -> form1;
            case 2, 3, 4 -> form2;
            default -> form5;
        };
    }
}
