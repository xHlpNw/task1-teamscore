package tasks;

import models.ArrayStatistics;
import utils.RandomUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Task6ArrayStatistics {
    /*
        1.6	СТАТИСТИКА
        Создайте класс ArrayStatistics,
        который получает массив целых чисел в конструкторе и содержит методы,
        возвращающие статистику по этому массиву:
        •	мода (mode);
        •	медиана (median);
        •	среднее арифметическое (average);
        •	дисперсия (variance);
        •	среднее геометрическое (geometric mean);
        •	перемешивание (shuffle) — возвращает новый массив, содержащий все
            элементы исходного в случайном порядке;
        •	выборка (sample) с параметром размера выборки —
            возвращает новый массив, содержащий случайные значения из исходного
            массива (значения могут повторяться, выборка может быть как меньше,
            так и больше исходного массива, контроль — нет посторонних чисел,
            они на случайных местах).

        Протестируйте методы на следующих краевых случаях:
        •	пустой массив;
        •	массив из одного элемента;
        •	массив из 3 элементов;
        •	вручную заполненный массив из 10 значений;
        •	массив из 100_000 значений случайных чисел с фиксированным seed.
    */

    public static void run() {
        System.out.println("\nTask 6.");
        System.out.println("===Empty array test===");
        test(new ArrayStatistics(new int[0]), 2);

        System.out.println("===One element array test===");
        test(new ArrayStatistics(new int[]{ 1987 }), 3);

        System.out.println("===[ 14, 26, 20 ] test===");
        test(new ArrayStatistics(new int[]{ 14, 26, 20 }), 5);

        System.out.println("===[ 0, 19, 231, 1000, 21, 104, 531, 17, 93, 84 ]===");
        test(new ArrayStatistics(
                        new int[]{ 0, 19, 231, 1000, 21, 104, 531, 17, 93, 84 }),
                5);

        System.out.println("===Big random generated array test===");
        test(new ArrayStatistics(
                        RandomUtils.generateRandomArray(
                                100_000,
                                0,
                                1000,
                                new Random(42))),
                5);

    }

    private static void test(ArrayStatistics stat, int sampleSize) {
        String text = """
                Modes: %s;
                Median: %s;
                Average: %s;
                Variance: %s;
                Geometric mean: %s;
                Shuffled: %s;
                Sample (%d): %s
                
                """;

        String sample;
        try {
            sample = Arrays.toString(stat.sampleWithRepeats(sampleSize));
        } catch (ArrayStoreException e) {
            sample = e.getMessage();
        }

        String geometricMean;
        try {
            geometricMean = Double.toString(stat.getGeometricMean());
        } catch (IllegalArgumentException e) {
            geometricMean = e.getMessage();
        }

        int[] shuffled = stat.shuffle();
        int displayLength = Math.min(shuffled.length, 100);
        StringBuilder shuffledString = new StringBuilder();
        shuffledString.append("[ ");
        shuffledString.append(Arrays.stream(shuffled, 0, displayLength)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ")));
        if (stat.getArray().length > displayLength) {
            shuffledString.append(", ...");
        }

        shuffledString.append(" ]");

        System.out.printf(
                text,
                stat.getModes().toString(),
                stat.getMedian(),
                stat.getAverage(),
                stat.getVariance(),
                geometricMean,
                shuffledString,
                sampleSize,
                sample
        );
    }
}
