import java.util.*;
import java.util.stream.Collectors;

public class ArrayStatistics {
    /*
        1.6	СТАТИСТИКА
        Создайте класс ArrayStatistics,
        который получает массив целых чисел в конструкторе и содержит методы,
        возвращающие статистику по этому массиву:
    */
    private int[] array;

    public ArrayStatistics() {
        this.array = Main.generateRandomArray(100, -1000, 1000);
    }

    public ArrayStatistics(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return this.array;
    }

    //    мода (mode) — одно или несколько наиболее часто встречающихся
    //    значений в массиве;
    public List<Integer> getModes() {
        if (array.length == 0) return new ArrayList<>(0);
        HashMap<Integer, Integer> counterMap = new HashMap<>();
        for (int val : array) {
            counterMap.put(val, counterMap.getOrDefault(val, 0) + 1);
        }

        int max = Collections.max(counterMap.values());

        List<Integer> modes = new ArrayList<>();
        for (int val : counterMap.keySet()) {
            if (counterMap.get(val) == max) modes.add(val);
        }

        return modes;
    }

    //    медиана (median) — значение, делящее массив пополам (ровно половина
    //    значений больше медианы и ровно половина меньше);
    public double getMedian() {
        if (array.length == 0) return Double.NaN;
        int[] sorted = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted);
        int length = sorted.length;
        if (length % 2 == 1) {
            return sorted[length/2];
        } else {
            return ((double)(sorted[length/2] + sorted[length/2 - 1])) / 2;
        }
    }

    //    среднее арифметическое (average);
    public double getAverage() {
        if (array.length == 0) return Double.NaN;

        long sum = 0;
        for (int val : array) sum += val;

        return (double) sum / array.length;
    }

    //    дисперсия (variance) — сумма квадратов отклонений от среднего
    //    арифметического;
    public double getVariance() {
        if (array.length == 0) return Double.NaN;

        double squaredDeviationsSum = 0;

        double avg = getAverage();
        for (int val : array) {
            squaredDeviationsSum += Math.pow(val - avg, 2);
        }
        return squaredDeviationsSum / array.length;
    }

    //    среднее геометрическое (geometric mean);
    public double getGeometricMean() {
        if (array.length == 0) return Double.NaN;

        double logSum = 0.0;

        for (int n : array) {
            if (n <= 0) {
                throw new IllegalArgumentException("Все элементы должны быть положительными");
            }
            logSum += Math.log(n);
        }

        return Math.exp(logSum / array.length);
    }

    //    перемешивание (shuffle) — возвращает новый массив, содержащий все
    //    элементы исходного в случайном порядке (контроль: каждое исходное
    //    значение встречается столько же раз, сколько в исходном массиве);
    public int[] shuffle() {
        int[] shuffled = Arrays.copyOf(array, array.length);
        Random rnd = new Random();

        for (int i = 0; i < shuffled.length - 1; i++) {
            int index = rnd.nextInt(i, shuffled.length);
            int temp = shuffled[i];
            shuffled[i] = shuffled[index];
            shuffled[index] = temp;
        }

        return shuffled;
    }

    //    выборка (sample) с параметром размера выборки —
    //    возвращает новый массив, содержащий случайные значения из исходного
    //    массива.
    public int[] sample(int size) {
        return Arrays.copyOf(shuffle(), size);
    }

    // с повтором
    public int[] sampleWithRepeats(int size) {
        int[] sampleArray = new int[size];
        Random rnd = new Random();

        if (array.length == 0) throw new ArrayStoreException("Невозможно получить выборку из пустого массива!");

        for (int i = 0; i < sampleArray.length; i++) {
            sampleArray[i] = array[rnd.nextInt(0, array.length)];
        }

        return sampleArray;
    }

    public void test(int sampleSize) {
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
            sample = Arrays.toString(sampleWithRepeats(sampleSize));
        } catch (ArrayStoreException e) {
            sample = e.getMessage();
        }

        try {
            sample = Arrays.toString(sampleWithRepeats(sampleSize));
        } catch (ArrayStoreException e) {
            sample = e.getMessage();
        }

        String geometricMean;
        try {
            geometricMean = Double.toString(getGeometricMean());
        } catch (IllegalArgumentException e) {
            geometricMean = e.getMessage();
        }

        int[] shuffled = shuffle();
        int displayLength = Math.min(shuffled.length, 100);
        StringBuilder shuffledString = new StringBuilder();
        shuffledString.append("[ ");
        shuffledString.append(Arrays.stream(shuffled, 0, displayLength)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ")));
        if (array.length > displayLength) {
            shuffledString.append(", ...");
        }

        shuffledString.append(" ]");

        System.out.printf(
                text,
                getModes().toString(),
                getMedian(),
                getAverage(),
                getVariance(),
                geometricMean,
                shuffledString,
                sampleSize,
                sample
                );
    }
}
