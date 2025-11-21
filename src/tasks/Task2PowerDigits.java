package tasks;

import java.math.BigInteger;

public class Task2PowerDigits {
    /*
        1.2	СТЕПЕНИ
        Заданы два целых числа 0 < a <= 2^(32) и 0 <= n <= 1000.
        Необходимо подсчитать, сколько десятичных цифр содержит число,
        которое получится при возведении в степень a^n.
    */

    public static void run() {
        System.out.println("\nTask 2.");

        long[] baseArr = { 1, 20, 2, 100, 2, (long)Math.pow(2, 32) };
        int[] exponentArr = { 5, 0, 10, 9, 1000, 1 };

        System.out.printf("%10s |%10s |%18s |%18s |\n",
                "Base", "Exponent", "BigInteger method", "Logarithm method");
        System.out.println("___________|___________|___________________|" +
                "___________________|");

        for (int i = 0; i < baseArr.length; i++) {
            long base = baseArr[i];
            int exponent = exponentArr[i];
            System.out.printf("%10d |%10d |%18d |%18d |\n",
                    base, exponent,
                    getPowerDigitsCountBigInteger(base, exponent),
                    getPowerDigitsCountLog(base, exponent));
        }

        System.out.println("___________|___________|___________________|" +
                "___________________|");
    }

    public static int getPowerDigitsCountBigInteger(long base, int exponent) {
        BigInteger bigIntegerBase = new BigInteger(String.valueOf(base));
        BigInteger result = bigIntegerBase.pow(exponent);
        return result.toString().length();
    }

    public static int getPowerDigitsCountLog(long base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        double digits = exponent * Math.log10(base);
        return (int) Math.floor(digits) + 1;
    }
}
