import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        1.1	ОКРУГЛЕНИЕ
        Напишите программу, которая выведет в виде таблицы округление
        (приведение дробного значения к целому) всеми возможными методами из
        класса Math для следующих значений:
        30.0, 10000.1, 12.5, 99.99, 0.0, -23.45, -4.5, -129.675.
        Поместите в репозиторий текстовый файл Conclusion.MD и кратко опишите,
        как именно выполняет округление каждый из методов.
        Форматирование Markdown приветствуется.
    */
        double[] values = {
                30.0, 10000.1, 12.5, 99.99, 0.0, -23.45, -4.5, -129.675
        };
        System.out.println("\nTask 1.");
        printRoundingTable(values);
    /*
        1.2	СТЕПЕНИ
        Заданы два целых числа 0 < a <= 2^(32) и 0 <= n <= 1000.
        Необходимо подсчитать, сколько десятичных цифр содержит число,
        которое получится при возведении в степень a^n.
    */
        long[] baseArr = {
            1, 20, 2, 100, 2, (long)Math.pow(2, 32)
        };
        int[] exponentArr = {
            5, 0, 10, 9, 1000, 1
        };

        System.out.println("\nTask 2.");
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

    /*
        1.3	ЗНАКОПОВТОРЕНИЯ
        Необходимо сгенерировать n случайных чисел в диапазоне [-100; 100] и
        определить самую длинную серию знакоповторений (количество идущих
        подряд чисел одного знака). 0 не является ни положительным, ни
        отрицательным числом и прерывает серию. Число n вводит пользователь.
    */
        System.out.println("\nTask 3.");
        Scanner scanner = new Scanner(System.in);
        int n = -1;
        while (n < 0) {
            System.out.print("Введите количество чисел для генерации: ");
            try {
                n = Integer.parseInt(scanner.next());
                if (n < 0) throw new IllegalArgumentException();
            } catch (Exception e) {
                System.out.println("Ошибка! Введите целое неотрицательное " +
                        "число в int диапазоне.");
            }
        }
        int[] array = generateRandomArray(n, -100, 100);
        int sequenceLength = getMaxSignumSequenceLength(array);
        System.out.printf("Максимальная длина последовательности: %s\n",
                sequenceLength);

    /*
        1.4	МЕСЯЦЫ
        Реализуйте класс MonthInfo, который будет выводить информацию о дате,
        переданной ему в конструкторе. Если дата не передана (конструктор без
        параметров), использовать текущую дату и время.
        Реализуйте методы, возвращающие:
        •	Полное название месяца на русском языке.
        •	Номер месяца в виде числа (1 — январь, 2 — февраль, …).
        •	День недели первого числа месяца в виде краткого текста
            (пн, вт, ср, чт, пт, сб, вс).
        •	Дату последнего дня месяца.
        •	Количество дней в месяце.
        •	Номер квартала, к которому относится месяц, с годом и приставкой Q
            ("2023 Q1", "2023 Q2", "2023 Q3", "2023 Q4").

        Тестовые примеры:
        Дата	    Результаты методов
        2023-11-12	ноябрь	11	ср	2023-11-30	30	2023 Q4
        1900-01-01	январь	1	пн	1900-01-31	31	1900 Q1
        2020-02-12	февраль	2	сб	2020-02-29	29	2020 Q1

    */
        System.out.println("\nTask 4.");

        System.out.println(new MonthInfo(LocalDate.of(2023, 11, 12)));
        System.out.println(new MonthInfo(LocalDate.of(1900, 1, 1)));
        System.out.println(new MonthInfo(LocalDate.of(2020, 2, 12)));
    /*
        1.5	ОБРАТНЫЙ ОТСЧЕТ
        Пользователь вводит дату и время какого-то события. Необходимо вывести,
        сколько до него осталось дней, часов, минут.
        Например, если сейчас 10.11.2025 10:31, а пользователь ввел
        01.12.2025 13:35 – это 21 день 3 часа и 4 минуты.
        •	Все числа выводить как целые.
        •	Если введенная дата и время ранее или равны текущим,
            вывести «Уже наступило!».
        •	Единицы времени больше дней (недели, месяцы, годы) выводить не
            нужно. Если получилось 100 дней – так и пишем.
        •	Если получается 0 дней, или 0 часов, или 0 минут – соответствующую
            часть пропустить.
        •	Окончания всех слов должны согласовываться с числом (1 день, 3 дня,
            1005 дней, 21 минута и т.д.). Желательно выделить отдельный метод,
            который будет выбирать нужный вариант окончания/слова.
        •	Циклы для решения не нужны.
        •	Добавьте возможность передать дату как аргумент командной строки.

    */
    /*
        1.6	СТАТИСТИКА
        Создайте класс ArrayStatistics,
        который получает массив целых чисел в конструкторе и содержит методы,
        возвращающие статистику по этому массиву:
        •	мода (mode) — одно или несколько наиболее часто встречающихся
            значений в массиве;
        •	медиана (median) — значение, делящее массив пополам (ровно половина
            значений больше медианы и ровно половина меньше);
        •	среднее арифметическое (average);
        •	дисперсия (variance) — сумма квадратов отклонений от среднего
            арифметического;
        •	среднее геометрическое (geometric mean);
        •	перемешивание (shuffle) — возвращает новый массив, содержащий все
            элементы исходного в случайном порядке (контроль: каждое исходное
            значение встречается столько же раз, сколько в исходном массиве);
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
        Для выборки и перемешивания проверьте соответсвие контрольным
        параметрам, и что при повторном вызове они возвращают другой массив.
        Примечание. Методы shuffle и sample довольно легко реализуются с
        помощью Random и стандартных методов Arrays.
    */
    /*
        1.7	СТЕК С ПРИОРИТЕТОМ
        Напишите реализацию обобщённого отсортированного стека с приоритетом:
        значения проталкиваются в стек в порядке приоритета, а извлекается
        всегда верхнее значение (с наивысшим приоритетом). Сами проталкиваемые
        в стек значения могут быть любого типа.

        Класс PriorityStack должен содержать методы:
        •	size - Количество элементов в стеке.
        •	push – протолкнуть в стек значение с указанным приоритетом.
            Чем меньше приоритет, тем выше (ближе к началу) элемент в стеке.
        •	pop - извлечь (удалить и вернуть) значение верхнего
            (первого) элемента в стеке.
        •	peek – посмотреть верхнее значение стека, не извлекая его.
    */
    }

    public static void printRoundingTable(double[] values) {
        /*
            1.1	ОКРУГЛЕНИЕ
            Напишите программу, которая выведет в виде таблицы округление всеми
            возможными методами из класса Math.
        */
        System.out.printf("%14s |%14s |%14s |%14s |%14s |%14s |\n",
                "value", "(int)", "rint", "round", "ceil", "floor");
        System.out.println("_______________|_______________|_______________|" +
                "_______________|_______________|_______________|");

        for (double val : values) {
            long cast = (long)val;
            long rint = (long)Math.rint(val);
            long round = Math.round(val);
            long ceil = (long)Math.ceil(val);
            long floor = (long)Math.floor(val);
            System.out.printf("%14s |%14d |%14d |%14d |%14d |%14d |\n",
                    val, cast, rint, round, ceil, floor);

        }
        System.out.println("_______________|_______________|_______________|" +
                "_______________|_______________|_______________|");

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

    public static int[] generateRandomArray(
            int quantity, int minValue, int maxValue) {
        Random rand = new Random();
        int[] randomArray = new int[quantity];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rand.nextInt(minValue, maxValue + 1);
        }
        return randomArray;
    }

    public static int getMaxSignumSequenceLength(int[] array) {
        int maxLength = 0;
        int sequenceStartIndex = 0;

        System.out.printf("%5s | %5s | %6s | %6s |\n",
                "index", "value", "signum", "length");

        System.out.println("______|_______|________|________|");
        for (int i = 0; i < array.length; i++){
            double sign = Math.signum(array[i]);
            if (sign == Math.signum(array[sequenceStartIndex]) && sign != 0d) {
                maxLength = Math.max(maxLength, i - sequenceStartIndex + 1);
            } else {
                sequenceStartIndex = i;
            }
            System.out.printf("%5s | %5s | %6s | %6s |\n",
                    i, array[i], sign, i - sequenceStartIndex + 1);
        }
        System.out.println("______|_______|________|________|");

        return maxLength;
    }
}