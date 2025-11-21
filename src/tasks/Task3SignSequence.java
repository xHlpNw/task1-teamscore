package tasks;

import utils.RandomUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Task3SignSequence {
    /*
        1.3	ЗНАКОПОВТОРЕНИЯ
        Необходимо сгенерировать n случайных чисел в диапазоне [-100; 100] и
        определить самую длинную серию знакоповторений (количество идущих
        подряд чисел одного знака). 0 не является ни положительным, ни
        отрицательным числом и прерывает серию. Число n вводит пользователь.
    */

    public static void run(Scanner scanner) {
        System.out.println("\nTask 3.");
        int n = -1;
        while (n < 0) {
            System.out.print("Введите количество чисел для генерации: ");
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n < 0) throw new IllegalArgumentException();
            } catch (Exception e) {
                System.out.println("Ошибка! Введите целое неотрицательное " +
                        "число в int диапазоне.");
            }
        }
        int[] array = RandomUtils.generateRandomArray(n, -100, 100);
        System.out.println(Arrays.toString(array));
        int sequenceLength = getMaxSignumSequenceLength(array);
        System.out.printf("Максимальная длина последовательности: %s\n",
                sequenceLength);
    }

    public static int getMaxSignumSequenceLength(int[] array) {
        int maxLength = 0;
        int sequenceStartIndex = 0;

        for (int i = 0; i < array.length; i++){
            double sign = Math.signum(array[i]);
            if (sign == Math.signum(array[sequenceStartIndex]) && sign != 0d) {
                maxLength = Math.max(maxLength, i - sequenceStartIndex + 1);
            } else {
                sequenceStartIndex = i;
            }
        }

        return maxLength;
    }
}
