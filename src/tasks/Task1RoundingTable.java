package tasks;

public class Task1RoundingTable {
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
    public static void run() {
        System.out.println("\nTask 1.");

        double[] values = {
                30.0, 10000.1, 12.5, 99.99,
                0.0, -23.45, -4.5, -129.675
        };

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
}
